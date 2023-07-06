package com.unicauca.openmarketms.access.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;

import io.swagger.annotations.ApiOperation;


public interface IDeliveryOrderRepository extends CrudRepository<DeliveryOrder, Long> {
   
    @ApiOperation("Obtiene órdenes pendientes")
    public List<DeliveryOrder> getAllPendingOrders();
}
