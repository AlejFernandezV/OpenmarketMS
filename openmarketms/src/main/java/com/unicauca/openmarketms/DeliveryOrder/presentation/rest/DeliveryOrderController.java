package com.unicauca.openmarketms.DeliveryOrder.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;
import com.unicauca.openmarketms.DeliveryOrder.domain.service.IDeliveryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("deliveryOrder")
public class DeliveryOrderController {
    @Autowired
    private IDeliveryService service;

    @ApiOperation("Obtiene todos los deliveries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<DeliveryOrder> findAll(){
        return(List<DeliveryOrder>) service.findAll();
    } 

    @ApiOperation("Busca los deliveries por su ID")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public DeliveryOrder findById(@PathVariable Long id) {
        return service.find(id);
    }

<<<<<<< HEAD:openmarketms/src/main/java/com/unicauca/openmarketms/presentation/rest/Delivery/DeliveryOrderController.java
    @ApiOperation("Obtiene las órdenes pendientes")
    @RequestMapping(value = "pending", method = RequestMethod.GET, produces = "application/json")
    public List<DeliveryOrder> getAllPendingOrders() {
        return service.getAllPendingOrders();
    }

    @ApiOperation("Crea una orden")
=======
>>>>>>> a96d01912c183a229c30a0ada41b23de51953c82:openmarketms/src/main/java/com/unicauca/openmarketms/DeliveryOrder/presentation/rest/DeliveryOrderController.java
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public DeliveryOrder create(@RequestBody DeliveryOrder deliveryOrder) {
        return service.create(deliveryOrder);
    }

    @ApiOperation("Actualiza una orden")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public DeliveryOrder update(@RequestBody DeliveryOrder deliveryOrder, @PathVariable Long id) {
        return service.update(id, deliveryOrder);
    }

    @ApiOperation("Elimina una orden")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
