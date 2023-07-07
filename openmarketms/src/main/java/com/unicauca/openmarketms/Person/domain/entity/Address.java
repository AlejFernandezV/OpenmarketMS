package com.unicauca.openmarketms.Person.domain.entity;

import java.io.Serializable;

import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable{
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    //Asociaciones
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @OneToOne
    @JoinColumn(name = "deliveryOrderId")
    private DeliveryOrder deliveryOrder;
}
