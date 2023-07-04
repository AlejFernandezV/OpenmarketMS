package com.unicauca.openmarketms.presentation.rest.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.openmarketms.domain.entity.Product.Product;
import com.unicauca.openmarketms.domain.service.Product.IProductService;


@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAll(){
        return(List<Product>) service.findAll();
    }
}
