package com.unicauca.openmarketms.domain.service.Delivery;

import java.util.List;

import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;
import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryStatus;
import com.unicauca.openmarketms.domain.service.IService;

public interface IDeliveryService extends IService <DeliveryOrder> {
    public List<DeliveryOrder> findByStatus(DeliveryStatus deliveryStatus);
}
