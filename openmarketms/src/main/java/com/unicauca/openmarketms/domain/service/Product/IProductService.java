package com.unicauca.openmarketms.domain.service.Product;

import java.util.List;

import com.unicauca.openmarketms.domain.entity.Product.Product;
import com.unicauca.openmarketms.domain.service.IService;

public interface IProductService extends IService <Product>{
    public List<Product> findAll();
    public List<Product> findForWord(String palabraClave, double price, String category, String ubication);
}
