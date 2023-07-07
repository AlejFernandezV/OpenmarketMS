package com.unicauca.openmarketms.Product.domain.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PickUpAddress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PickUpAddress implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;
}
