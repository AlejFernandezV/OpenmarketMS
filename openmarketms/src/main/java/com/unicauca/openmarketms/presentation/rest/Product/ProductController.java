package com.unicauca.openmarketms.presentation.rest.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.openmarketms.domain.entity.Product.Product;
import com.unicauca.openmarketms.domain.service.Product.IProductService;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /*
     * Busca todos los productos
     * 
     * @return Lista de productos
     */
    @ApiOperation("Obtiene todos los productos.")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAll(){
        return(List<Product>) productService.findAll();
    }

    @RequestMapping(value = "{palabraClave}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> buscarProducts(@PathVariable String palabraClave){
        return productService.buscarProductos(palabraClave);
    }
}
