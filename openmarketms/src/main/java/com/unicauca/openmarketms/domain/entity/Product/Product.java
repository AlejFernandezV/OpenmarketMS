package com.unicauca.openmarketms.domain.entity.Product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.bind.Name;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "Product")
@Data
@ApiModel(description = "Productos")
public class Product implements Serializable{
    
    public Product(long productId, String nameProduct, String description, double price, String category, String ubication, int quantity){
        this.id = productId;
        this.name = nameProduct;
        this.description = description;
        this.price = price;
        this.category = category;
        this.ubication = ubication;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    @NotNull(message = "El ID para el producto es obligatorio")
    @ApiModelProperty(notes = "ID único para el producto", example = "01")
    private long id;

    @Column(name = "productName")
    @NotNull(message = "El nombre para el producto es obligatorio")
    private String name;

    @Column(name = "productDescription")
    @NotNull(message = "La descripción para el producto es obligatorio")
    private String description;

    @Column(name = "productPrice")
    @NotNull(message = "El precio para el producto es obligatorio")
    private double price;

    @Column(name = "productCategory")
    @NotNull(message = "La categoria para el producto es obligatorio")
    private String category;

    @Column(name = "productUbication")
    @NotNull(message = "La ubicación para el producto es obligatorio")
    private String ubication;

    @Column(name = "productQuantity")
    @NotNull(message = "La cantidad del producto es obligatoria")
    private int quantity;

    //Servicios


    //Operaciones
    

}
