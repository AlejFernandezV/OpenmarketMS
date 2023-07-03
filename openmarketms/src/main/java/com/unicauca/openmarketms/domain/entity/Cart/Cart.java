package com.unicauca.openmarketms.domain.entity.Cart;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.unicauca.openmarketms.domain.entity.Person.Person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
@ApiModel(description = "Representa un carrito de compras")
public class Cart implements Serializable {

    // Constructor
    public Cart(long id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    // Atributos
    @Id
    @Column(name = "cartId")
    @NotNull(message = "El ID del carrito es obligatorio")
    @ApiModelProperty(notes = "ID único del carrito", example = "1")
    private long id;

    // Asociaciones
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @ApiModelProperty(notes = "Comprador asociado al carrito")
    private Person buyer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(notes = "Elementos del carrito")
    private ArrayList<CartItem> items;

    // Operaciones
    /**
     * Agrega un elemento al carrito.
     *
     * @param item El elemento del carrito a agregar
     * @return true si se agrega correctamente, false si el elemento es nulo
     */
    public boolean addItem(CartItem item) {
        if (item == null) {
            return false;
        }
        this.items.add(item);
        return true;
    }

    /**
     * Elimina un elemento del carrito.
     *
     * @param item El elemento del carrito a eliminar
     * @return true si se elimina correctamente, false si el elemento es nulo o no se encuentra en el carrito
     */
    public boolean removeItem(CartItem item) {
        if (item == null) {
            return false;
        }
        for (CartItem cartItem : this.items) {
            if (cartItem.equals(item)) {
                this.items.remove(item);
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza el proceso de pago y finaliza la compra.
     */
    public void checkOut() {
        // Implementa el proceso de pago y finalización de la compra
    }
}
