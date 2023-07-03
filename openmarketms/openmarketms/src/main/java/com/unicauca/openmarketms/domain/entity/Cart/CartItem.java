package com.unicauca.openmarketms.domain.entity.Cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.unicauca.openmarketms.domain.entity.Product.Product;

import lombok.Data;

@Entity
@Table(name = "CartItem")
@Data
public class CartItem {
    
   /* public CartItem(Product product){
        this.id = product.getId();
        this.quantity = product.getQuantity();
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Quantity")
    @NotNull(message = "La cantidad es obligatoria")
    private int quantity;
}
