package com.unicauca.openmarketms.domain.service.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketms.access.repository.IProductRepository;
import com.unicauca.openmarketms.domain.entity.Product.Product;

@Service
public class ProductServiceImpl implements IProductService{
    
    @Autowired
    private IProductRepository repository;

    /**
     * Busca todos los productos
     * 
     * @return Lista de productos
     */
    @Override
    public List<Product> findAll(){
        return (List<Product>) repository.findAll();
    }


    /**
     * Busca todos los productos por coincidencia en nombre o descripcion
     * 
     * @param palabraClave palabra clave por la cual se busca el producto
     * @return Lista de productos
     */
    @Override
    public List<Product> buscarProductos(String palabraClave) {
        List<Product> productos = new ArrayList<>();
        List<Product> found = new ArrayList<>();

        for (Product producto : productos) {
            if (palabraClave != null && (producto.getName().contains(palabraClave) || producto.getDescription().contains(palabraClave))) {
                found.add(producto);
            }
        }

        return found;
    }
}
