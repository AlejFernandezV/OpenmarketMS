package com.unicauca.openmarketms.domain.service.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        updateProduct.setDescription(p.getDescription());
        updateProduct.setPrice(p.getPrice());
        updateProduct.setQuantity(p.getQuantity());
        return repository.save(updateProduct);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
