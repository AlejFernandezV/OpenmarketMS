package com.unicauca.openmarketms.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.domain.entity.Cart.Cart;

public interface ICartRepository extends CrudRepository<Cart, Long>{
    
}