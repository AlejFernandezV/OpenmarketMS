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

    /**
     * Busca todos los pedidos
     * 
     * @return Lista de pedidos
     */
    @Override
    public List<DeliveryOrder> findAll() {
        return (List<DeliveryOrder>) repository.findAll();
    }

     /**
     * Busca un pedido por su id
     * 
     * @param id id del pedido
     * @return pedido
     */
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
    public List<DeliveryOrder> getAllPendingOrders() {
        List<DeliveryOrder> pendingOrders = this.findAll();

        for(DeliveryOrder order : pendingOrders){
            if(!order.getStatus().equals(DeliveryStatus.STATUS_PENDING)){
                pendingOrders.remove(order);
            }
        }
        return pendingOrders;
    }    
}
