package com.unicauca.openmarketms.access.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.unicauca.openmarketms.domain.entity.Product.Product;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface IProductRepository extends CrudRepository<Product, Long>{

    @ApiOperation("Busca los productos de acuerdo a una palabra o ciertos filtros")
    public List<Product> findForWord(@ApiParam(value = "Palabra clave", required = true) @RequestParam("palabraClave") String palabraClave, 
                                    @ApiParam(value = "Precio", required = false) @RequestParam("price") double price, 
                                    @ApiParam(value = "Categoria", required = false) @RequestParam("category") String category, 
                                    @ApiParam(value = "Ubicacion", required = false) @RequestParam("ubication") String ubication);
}
