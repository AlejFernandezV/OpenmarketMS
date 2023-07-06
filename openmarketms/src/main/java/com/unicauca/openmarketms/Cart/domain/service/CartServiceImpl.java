package com.unicauca.openmarketms.Cart.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketms.Cart.access.repository.ICartRepository;
import com.unicauca.openmarketms.Cart.domain.entity.Cart;
import com.unicauca.openmarketms.Cart.domain.entity.CartItem;
import com.unicauca.openmarketms.Commons.DeliveryOrderProducer;
import com.unicauca.openmarketms.DeliveryOrder.access.repository.IDeliveryOrderRepository;
import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;
import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryStatus;
import com.unicauca.openmarketms.Product.domain.service.IProductService;

@Service
public class CartServiceImpl implements ICartService{
    
    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private IDeliveryOrderRepository DORepository;
    @Autowired
    private IProductService productService;
    
    /**
     * Busca todos los carritos
     * 
     * @return Lista de carritos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cart> findAll() {
        return (List<Cart>) cartRepository.findAll();
    }

    /**
     * Busca un carrito por su id
     * 
     * @param id id del carrito
     * @return carrito
     */
    @Override
    @Transactional
    public Cart find(Long id) {
        Cart actCart = cartRepository.findById(id).orElse(null);
        return actCart;
    }

    /**
     * Crea un carrito
     * 
     * @param actCart carrito a crear
     * @return carrito creado
     */
    @Override
    public Cart create(Cart actCart) {
        return cartRepository.save(actCart);
    }

    /**
     * Actualiza un carrito
     * 
     * @param id      id del carrito
     * @param actCart carrito a actualizar
     * @return carrito actualizado
     */
    @Override
    public Cart update(Long id, Cart actCart) {
        Cart cartUpdate = this.find(id);
        cartUpdate.setId(actCart.getId());
        cartUpdate.setItems(actCart.getItems());
        return cartRepository.save(cartUpdate);
    }

    /**
     * Elimina un carrito
     * 
     * @param id id del carrito
     */
    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    /**
     * Agrega un elemento al carrito.
     *
     * @param Id Id del carrito al que se le va a agregar el item
     * @param item El elemento del carrito a agregar
     * @return true si se agrega correctamente, false si el elemento es nulo
     */
    public boolean addItem(Long Id, CartItem item) {
        if (item == null) {
            return false;
        }
        this.find(Id).getItems().add(item);
        return true;
    }

    /**
     * Elimina un elemento del carrito.
     *
     * @param item El elemento del carrito a eliminar
     * @return true si se elimina correctamente, false si el elemento es nulo o no se encuentra en el carrito
     */
    public boolean removeItem(Long Id,CartItem item) {
        if (item == null) {
            return false;
        }
        ;

        for (CartItem cartItem : this.find(Id).getItems()) {
            if (cartItem.equals(item)) {
                this.find(Id).getItems().remove(item);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Genera un deliveryOrder por cada ítem del carrito.  Luego del check out, 
     * el carrito queda vacío y se da de baja el stock en Producto
     */
    
    public void checkOut(Long Id) {
        DeliveryOrderProducer deliOrderProd = new DeliveryOrderProducer();
        Cart cart = this.find(Id);

        for(CartItem item: cart.getItems()){
            //Crea y setea la informacion a la deliveryOrder
            DeliveryOrder objDeliveryOrder = new DeliveryOrder();
            objDeliveryOrder.setQuantity(item.getQuantity());
            objDeliveryOrder.setProduct(item.getProduct());
            objDeliveryOrder.setCompradorAddress(null);
            objDeliveryOrder.setStatus(DeliveryStatus.STATUS_PENDING);
            
            //Se agrega al repositorio de deliveryOrders
            this.DORepository.save(objDeliveryOrder);

            //Se encola la orden a su respectiva exchange        
            try {
                deliOrderProd.sendMessage(objDeliveryOrder);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
             
            //Se actualiza la cantidad de productos en su repo
            item.getProduct().setQuantity(item.getProduct().getQuantity() - item.getQuantity());
            this.productService.update(item.getProduct().getId(), item.getProduct());
        }
        //Se limpia el carrito de compras
        cart.getItems().clear();
    }
    
}
