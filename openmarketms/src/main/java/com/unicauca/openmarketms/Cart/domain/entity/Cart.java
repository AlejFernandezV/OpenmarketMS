package com.unicauca.openmarketms.Cart.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.unicauca.openmarketms.Person.domain.entity.Person;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "cart")
@Data
@Getter
@Setter
public class Cart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El ID del carrito es obligatorio")
    private Long id;

    // Asociaciones
    @OneToOne(mappedBy = "cart")
    private Person buyer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> items;

    // Constructor
    public Cart(long cartId, Person buyer) {
        this.id = cartId;
        this.buyer = buyer;
        this.items = new ArrayList<>();
    }
}
