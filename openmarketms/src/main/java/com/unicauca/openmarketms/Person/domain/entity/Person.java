package com.unicauca.openmarketms.Person.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.unicauca.openmarketms.Cart.domain.entity.Cart;
import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;
import com.unicauca.openmarketms.Product.domain.entity.Product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", nullable = false, length = 80)
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "Birthdate", nullable = true)
    private Date birthdate;

    @Column(name = "Email", nullable = false, length = 60)
    @NotNull(message = "El email es obligatorio")
    private String email;

    @Column(name = "Password", nullable = false, length = 60)
    @NotNull(message = "La contraseña es obligatoria")
    private String password;

    @Column(name = "Role", nullable = false, length = 60)
    @NotNull(message = "El rol es obligatorio")
    private String role;

    //Asociaciones
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "deliveryOrderId")
    private DeliveryOrder deliveryOrder;

}
