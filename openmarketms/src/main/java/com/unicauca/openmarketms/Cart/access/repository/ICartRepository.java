package com.unicauca.openmarketms.Cart.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.Cart.domain.entity.Cart;

public interface ICartRepository extends CrudRepository<Cart, Long>{
    
}
