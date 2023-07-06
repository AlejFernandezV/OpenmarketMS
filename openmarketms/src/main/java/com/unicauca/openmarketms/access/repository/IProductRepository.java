package com.unicauca.openmarketms.access.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.domain.entity.Product.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{
    public List<Product> findForWord(String palabraClave, double price, String category, String ubication);
}
