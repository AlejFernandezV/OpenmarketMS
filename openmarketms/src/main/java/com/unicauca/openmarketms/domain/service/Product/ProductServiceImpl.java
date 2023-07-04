package com.unicauca.openmarketms.domain.service.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openmarketms.domain.entity.Product.Product;

@Service
public class ProductServiceImpl {
    
    @Autowired
    private IProductService repository;

    @Override
    public List<Product> findAll(){
        return (List<Product>) repository.findAll();
    }

    @Override
    public Product find(Strind name){
        //Product prod = repository.findById
    }
}
