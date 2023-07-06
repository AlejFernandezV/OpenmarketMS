package com.unicauca.openmarketms.domain.entity.Product;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "Prodict")
@Data
@ApiModel(description = "Productos")
public class PickUpAddress {

    public PickUpAddress(long pickUpId, double pickUpLongitude, double pickUpLatitude) {
        this.pickUpId = pickUpId;
        this.pickUpLongitude = pickUpLongitude;
        this.pickUpLatitude = pickUpLatitude;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pickUpId")
    @NotNull(message = "El ID para la dirección de entrega del producto es obligatoria")
    @ApiModelProperty(notes = "ID único para la dirección de entrega del producto", example = "01")
    private long pickUpId;
    
    @Column(name = "pickUpLongitude")
    @NotNull(message = "La longitud para la direccion de entrega del producto es obligatoria")
    private double pickUpLongitude;
    
    @Column(name = "pickUpLatitude")
    @NotNull(message = "La latitud para la direccion de entrega del producto es obligatoria")
    private double pickUpLatitude;
}
