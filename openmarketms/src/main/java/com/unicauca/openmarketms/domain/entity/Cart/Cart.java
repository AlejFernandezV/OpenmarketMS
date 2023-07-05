package com.unicauca.openmarketms.domain.entity.Cart;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;
import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryStatus;
import com.unicauca.openmarketms.domain.service.Delivery.DeliveryServiceImpl;
import com.unicauca.openmarketms.domain.service.Product.ProductServiceImpl;
import com.unicauca.openmarketms.domain.service.RabbitMQ.DeliveryOrderProducer;
import com.unicauca.openmarketms.domain.service.User.PersonServiceImpl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
@ApiModel(description = "Representa un carrito de compras")
public class Cart implements Serializable {

    // Constructor
    public Cart(long cartId, long buyerId) {
        this.id = cartId;
        this.buyerId = buyerId;
        this.items = new ArrayList<>();
    }

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId")
    @NotNull(message = "El ID del carrito es obligatorio")
    @ApiModelProperty(notes = "ID único del carrito", example = "1")
    private long id;

    // Asociaciones
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @ApiModelProperty(notes = "Comprador asociado al carrito")
    private long buyerId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "Elementos del carrito")
    private ArrayList<CartItem> items;

    //Servicios
    private DeliveryServiceImpl deliveryService; 
    private PersonServiceImpl personService;
    private ProductServiceImpl productService;

    // Operaciones
    /**
     * Agrega un elemento al carrito.
     *
     * @param item El elemento del carrito a agregar
     * @return true si se agrega correctamente, false si el elemento es nulo
     */
    public boolean addItem(CartItem item) {
        if (item == null) {
            return false;
        }
        this.items.add(item);
        return true;
    }

    /**
     * Elimina un elemento del carrito.
     *
     * @param item El elemento del carrito a eliminar
     * @return true si se elimina correctamente, false si el elemento es nulo o no se encuentra en el carrito
     */
    public boolean removeItem(CartItem item) {
        if (item == null) {
            return false;
        }
        for (CartItem cartItem : this.items) {
            if (cartItem.equals(item)) {
                this.items.remove(item);
                return true;
            }
        }
        return false;
    }

    /**
     * Genera un deliveryOrder por cada ítem del carrito.  Luego del check out, 
     * el carrito queda vacío y se da de baja el stock en Producto
     */
    public void checkOut() {
        DeliveryOrderProducer deliOrderProd = new DeliveryOrderProducer();
        for(CartItem item: this.items){
            //Crea y setea la informacion a la deliveryOrder
            DeliveryOrder objDeliveryOrder = new DeliveryOrder();
            objDeliveryOrder.setQuantity(item.getQuantity());
            objDeliveryOrder.setProduct(item.getProduct());

            objDeliveryOrder.setCompradorAddress(this.personService.find(this.buyerId).getAddresses().get(0));

            objDeliveryOrder.setStatus(DeliveryStatus.STATUS_PENDING);
            
            //Se agrega al repositorio de deliveryOrders
            this.deliveryService.create(objDeliveryOrder);

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
        this.items.clear();
    }
}
