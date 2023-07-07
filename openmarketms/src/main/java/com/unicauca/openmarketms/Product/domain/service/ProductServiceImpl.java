package com.unicauca.openmarketms.Product.domain.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openmarketms.Product.access.repository.IProductRepository;
import com.unicauca.openmarketms.Product.domain.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository repository;

    @Override
    public Product find(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product object) {
        return repository.save(object);
    }

    @Override
    public Product update(Long id, Product p) {
        Product updateProduct = this.find(id);
        updateProduct.setId(p.getId());
        updateProduct.setName(p.getName());
        updateProduct.setQuantity(p.getQuantity());
        return repository.save(updateProduct);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }
}
