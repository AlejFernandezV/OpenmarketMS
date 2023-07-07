package com.unicauca.openmarketms.Product.domain.entity;

import java.io.Serializable;

import com.unicauca.openmarketms.Cart.domain.entity.CartItem;
import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;
import com.unicauca.openmarketms.Person.domain.entity.Person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "ubication")
    private String ubication;

    //Asociaciones
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @OneToOne
    @JoinColumn(name = "cartItemId")
    private CartItem cartItem;

    @OneToOne(mappedBy = "product")
    private PickUpAddress vendorAddress;

    @OneToOne
    @JoinColumn(name = "deliveryOrderId")
    private DeliveryOrder deliveryOrder;
}
