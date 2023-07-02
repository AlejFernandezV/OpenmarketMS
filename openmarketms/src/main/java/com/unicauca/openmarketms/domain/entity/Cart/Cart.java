package com.unicauca.openmarketms.domain.entity.Cart;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "Cart")
@Data
public class Cart implements Serializable{
    
    public Cart(long id){
        this.id = id;
        this.Items = new ArrayList<>();
    }

    @Id
    @Column(name = "cartId")
    @NotNull(message = "El id del carrito es obligatorio")
    private long id;

    private ArrayList<CartItem> Items;
    
    public boolean addItem(CartItem item){
        if(item.equals(null)){
            return false;
        }
        this.Items.add(item);
        return true;
    }

    public boolean removeItem(CartItem item){
        if(item.equals(null)){
            return false;
        }
        for(CartItem cartItem: this.Items){
            if(cartItem.equals(item)){
                this.Items.remove(item);
                return true;
            }
        }
        return false;
    }

    public void checkOut(){

    }


}
