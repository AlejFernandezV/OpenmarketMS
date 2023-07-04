package com.unicauca.openmarketms.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.domain.entity.Product.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{
    
}
