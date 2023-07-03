package com.unicauca.openmarketms.domain.entity.Delivery;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.unicauca.openmarketms.domain.entity.Person.Address;
import com.unicauca.openmarketms.domain.entity.Person.Person;
import com.unicauca.openmarketms.domain.entity.Product.Product;
import com.unicauca.openmarketms.domain.service.Delivery.IDeliveryService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Order details")
@Entity
@Table(name = "deliveryOrder")
@Data
public class DeliveryOrder implements Serializable {
    
    @Autowired
    private IDeliveryService service;
    public DeliveryOrder (int quantity, DeliveryStatus status, Product product, Address compradorAddress, Person deliver){
        this.quantity= quantity;
        this.status = status;
        this.product = product;
        this.compradorAddress = compradorAddress; 
        this.deliver = deliver;
    }

    public DeliveryOrder(){

    }

    @ApiModelProperty(notes = "Delivery person")
    private Person deliver; 

    @ApiModelProperty(notes = "Buyer's address")
    private Address compradorAddress; 

    @ApiModelProperty(notes = "Product details")
    private Product product; 

    @ApiModelProperty(notes = "Order ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Order quantity")
    @Column(name = "Quantity")
    @NotNull(message = "La cantidad es obligatoria.")
    private int quantity;

    @ApiModelProperty(notes = "Order status")
    @Column(name = "Status")
    @NotNull(message = "El Estado es obligatorio.")
    private DeliveryStatus status;

    

    public void procesarMensaje(String message) {
        String[] partes = message.split(",");
        String action = partes[0];
        Long id = Long.parseLong(partes[0]);
        int quantity = Integer.parseInt(partes[1]);
        DeliveryStatus status = DeliveryStatus.valueOf(partes[2]);
        /*DeliveryOrder deliveryOrder = new DeliveryOrder(id, quantity, status);

        switch(action){
            case "POST": this.service.create(deliveryOrder); break;
            case "PUT": this.service.update(id, deliveryOrder); break;
            case "DELETE": this.service.delete(id); break;
            case "GET": this.service.findByStatus(DeliveryStatus.STATUS_PENDING); break;
            default: System.out.println("Error! Action not found"); break;
        }*/
    }
}
