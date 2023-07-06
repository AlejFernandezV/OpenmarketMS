package com.unicauca.openmarketms.Product.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.Product.domain.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{

}
