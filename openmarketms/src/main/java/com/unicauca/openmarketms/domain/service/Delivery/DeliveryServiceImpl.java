package com.unicauca.openmarketms.domain.service.Delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openmarketms.access.repository.IDeliveryOrderRepository;
import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;
import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryStatus;

@Service
public class DeliveryServiceImpl implements IDeliveryService{

    @Autowired
    private IDeliveryOrderRepository repository;

    @Override
    public List<DeliveryOrder> findAll() {
        return (List<DeliveryOrder>) repository.findAll();
    }

    @Override
    public DeliveryOrder find(Long id) {
        DeliveryOrder idDeliveryOrder = repository.findById(id).orElse(null);
        return idDeliveryOrder;
    }

    @Override
    public DeliveryOrder create(DeliveryOrder object) {
        return repository.save(object);
    }

    @Override
    public DeliveryOrder update(Long id, DeliveryOrder object) {
        DeliveryOrder updatDeliveryOrder = this.find(id);
        updatDeliveryOrder.setId(object.getId());
        updatDeliveryOrder.setQuantity(object.getQuantity());
        updatDeliveryOrder.setStatus(object.getStatus());
        return repository.save(updatDeliveryOrder);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DeliveryOrder> findByStatus(DeliveryStatus deliveryStatus) {
        return (List<DeliveryOrder>) repository.findByStatus(deliveryStatus);
    }    
}
