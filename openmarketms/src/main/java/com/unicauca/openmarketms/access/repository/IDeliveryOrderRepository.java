package com.unicauca.openmarketms.access.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;

public interface IDeliveryOrderRepository extends CrudRepository<DeliveryOrder, Long> {
    public List<DeliveryOrder> getAllPendingOrders();
}
