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
    public List<Product> findForWord(String palabraClave, double price, String category, String ubication) {
        List<Product> prdcts = new ArrayList<>();
        List<Product> found = new ArrayList<>();

        for (Product prdct : prdcts) {
            if (palabraClave != null && (prdct.getName().contains(palabraClave) || prdct.getDescription().contains(palabraClave))) {
                found.add(prdct);
            }
            if (price == prdct.getPrice()){
                found.add(prdct);
            }
            if (category == prdct.getCategory()){
                found.add(prdct);
            }
            if (ubication == prdct.getUbication()){
                found.add(prdct);
            }
        }

        return found;
    }

    @Override
    public Product find(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public Product create(Product object) {
        // TODO Auto-generated method stub
                return repository.save(object);
    }

    @Override
    public Product update(Long id, Product object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
