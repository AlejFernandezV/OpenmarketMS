package com.unicauca.openmarketms.DeliveryOrder.domain.entity;

import java.io.Serializable;

import com.unicauca.openmarketms.Person.domain.entity.Address;
import com.unicauca.openmarketms.Person.domain.entity.Person;
import com.unicauca.openmarketms.Product.domain.entity.Product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "deliveryOrder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrder implements Serializable{
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private DeliveryStatus status;

    //Asociaciones
    @OneToOne(mappedBy = "deliveryOrder")
    private Person deliver;

    @OneToOne(mappedBy = "deliveryOrder")
    private Product product;

    @OneToOne(mappedBy = "deliveryOrder")
    private Address compradorAddress;
}
