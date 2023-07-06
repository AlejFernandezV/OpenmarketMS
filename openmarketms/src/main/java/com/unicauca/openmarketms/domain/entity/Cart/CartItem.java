package com.unicauca.openmarketms.domain.entity.Cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

import com.unicauca.openmarketms.domain.entity.Product.Product;

import lombok.Data;

@Entity
@Table(name = "CartItem")
@Data
@ApiModel(description = "Representa un elemento del carrito de compras")
public class CartItem {

    // Constructor
    public CartItem(Product product) {
        this.product = product;
        this.id = product.getId();
        this.quantity = product.getQuantity();
    }

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID único del elemento del carrito", example = "1")
    private long id;

    @Column(name = "Quantity")
    @NotNull(message = "La cantidad es obligatoria")
    @ApiModelProperty(notes = "Cantidad del producto en el carrito", example = "2")
    private int quantity;

    // Asociaciones
    @JoinColumn(name = "product_id")
    @ApiModelProperty(notes = "Producto asociado al elemento del carrito")
    private Product product;
}

