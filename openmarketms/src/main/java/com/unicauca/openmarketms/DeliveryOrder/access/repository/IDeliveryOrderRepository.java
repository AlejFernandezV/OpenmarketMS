package com.unicauca.openmarketms.DeliveryOrder.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;

public interface IDeliveryOrderRepository extends CrudRepository<DeliveryOrder, Long> {
    
}
