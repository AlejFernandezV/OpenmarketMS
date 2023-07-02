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

import com.unicauca.openmarketms.domain.service.Delivery.IDeliveryService;

import lombok.Data;

@Entity
@Table(name = "deliveryOrder")
@Data
public class DeliveryOrder implements Serializable {
    
    @Autowired
    private IDeliveryService service;
    public DeliveryOrder (Long id, int quantity, DeliveryStatus status){
        this.id = id;
        this.quantity= quantity;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Quantity")
    @NotNull(message = "La cantidad es obligatoria.")
    private int quantity;

    @Column(name = "Status")
    @NotNull(message = "El Estado es obligatorio.")
    private DeliveryStatus status;

    public void procesarMensaje(String message) {
        String[] partes = message.split(",");
        String action = partes[0];
        Long id = Long.parseLong(partes[0]);
        int quantity = Integer.parseInt(partes[1]);
        DeliveryStatus status = DeliveryStatus.valueOf(partes[2]);
        DeliveryOrder deliveryOrder = new DeliveryOrder(id, quantity, status);

        switch(action){
            case "POST": this.service.create(deliveryOrder); break;
            case "PUT": this.service.update(id, deliveryOrder); break;
            case "DELETE": this.service.delete(id); break;
            case "GET": this.service.findByStatus(DeliveryStatus.STATUS_PENDING); break;
            default: System.out.println("Error! Action not found"); break;
        }
    }
}
