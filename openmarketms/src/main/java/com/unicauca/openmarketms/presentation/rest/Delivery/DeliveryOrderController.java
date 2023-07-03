package com.unicauca.openmarketms.presentation.rest.Delivery;

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

import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;
import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryStatus;
import com.unicauca.openmarketms.domain.service.Delivery.IDeliveryService;

@RestController
@RequestMapping("deliveryOrder")
public class DeliveryOrderController {
    
    @Autowired
    private IDeliveryService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<DeliveryOrder> findAll(){
        return(List<DeliveryOrder>) service.findAll();
    } 

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public DeliveryOrder findById(@PathVariable Long id) {
        return service.find(id);
    }

    @RequestMapping(value = "pending", method = RequestMethod.GET, produces = "application/json")
    public List<DeliveryOrder> getAllPendingOrders() {
        return service.getAllPendingOrders();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public DeliveryOrder create(@RequestBody DeliveryOrder deliveryOrder) {
        return service.create(deliveryOrder);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public DeliveryOrder update(@RequestBody DeliveryOrder deliveryOrder, @PathVariable Long id) {
        return service.update(id, deliveryOrder);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
