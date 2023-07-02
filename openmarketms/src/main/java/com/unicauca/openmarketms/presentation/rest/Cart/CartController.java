package com.unicauca.openmarketms.presentation.rest.Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.openmarketms.domain.entity.Cart.Cart;
import com.unicauca.openmarketms.domain.service.Cart.ICartService;

@RestController
@RequestMapping("Cart")
public class CartController {
    
    @Autowired
    private ICartService cartService;
    
    /**
     * Busca todos los carritos de compra
     * 
     * @return Lista de carritos de compras
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Cart> findAll(){
        return(List<Cart>) cartService.findAll();
    }    

    /**
     * Busca un carrito de compras por su id
     * 
     * @param id id del carrito
     * @return carrito
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Cart findById(@PathVariable Long id) {
        return cartService.find(id);
    }

    /**
     * Crea un carrito
     * 
     * @param cart carrito a crear
     * @return carrito creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    /**
     * Actualiza un carrito
     * 
     * @param cart carrito a actualizar
     * @param id      id del carrito a actualizar
     * @return carrito actualizado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Cart update(@RequestBody Cart cart, @PathVariable Long id) {
        return cartService.update(id, cart);
    }

    /**
     * Elimina un carrito
     * 
     * @param id id del carrito a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cartService.delete(id);
    }
}
