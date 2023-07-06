package com.unicauca.openmarketms.DeliveryOrder.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openmarketms.DeliveryOrder.access.repository.IDeliveryOrderRepository;
import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryOrder;
import com.unicauca.openmarketms.DeliveryOrder.domain.entity.DeliveryStatus;

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

    public List<DeliveryOrder> getAllPendingOrders(){
        List<DeliveryOrder> pendingOrders = this.findAll();
        for(DeliveryOrder order : pendingOrders){
            if(!order.getStatus().equals(DeliveryStatus.STATUS_PENDING)){
                pendingOrders.remove(order);
            }
        }
        return pendingOrders;
    }

    public void procesarMensaje(String message){
        String [] split = message.split(",");
        
        // Obtener el ID del pedido del mensaje
        Long idLong = Long.parseLong(split[0]);

        // Buscar el pedido utilizando el servicio
        DeliveryOrder deliveryOrder = this.find(idLong);

        // Si se encuentra el pedido, establecer el estado en STATUS_PICKEDUP, si no, mostrar mensaje de error
        if (!deliveryOrder.equals(null)){
            deliveryOrder.setStatus(DeliveryStatus.STATUS_PICKEDUP);
        }else{
            System.out.println("Error! No se encontro el pedido.");
        }
    }
}
