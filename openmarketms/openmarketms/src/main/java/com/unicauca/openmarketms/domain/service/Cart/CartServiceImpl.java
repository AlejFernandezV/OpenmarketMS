package com.unicauca.openmarketms.domain.service.Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketms.access.repository.ICartRepository;
import com.unicauca.openmarketms.domain.entity.Cart.Cart;

@Service
public class CartServiceImpl implements ICartService{
    @Autowired
    private ICartRepository repository;

    /**
     * Busca todos los carritos
     * 
     * @return Lista de carritos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cart> findAll() {
        return (List<Cart>) repository.findAll();
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
        Cart actCart = repository.findById(id).orElse(null);
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
        return repository.save(actCart);
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
        return repository.save(cartUpdate) ;
    }

    /**
     * Elimina un carrito
     * 
     * @param id id del carrito
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
