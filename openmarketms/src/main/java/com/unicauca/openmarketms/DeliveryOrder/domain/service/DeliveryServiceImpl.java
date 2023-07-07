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

    /**
     * crea una orden 
     * 
     * @param object
     * @return orden creada
     */
    @Override
    public DeliveryOrder create(DeliveryOrder object) {
        return repository.save(object);
    }

    /**
     * Actualiza una orden
     * 
     * @param id
     * @param object
     * @return orden actualizada
     */
    @Override
    public DeliveryOrder update(Long id, DeliveryOrder object) {
        DeliveryOrder updatDeliveryOrder = this.find(id);
        updatDeliveryOrder.setId(object.getId());
        updatDeliveryOrder.setQuantity(object.getQuantity());
        updatDeliveryOrder.setStatus(object.getStatus());
        return repository.save(updatDeliveryOrder);
    }

    /**
     * Elimina una orden
     * 
     * @param id
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

<<<<<<< HEAD:openmarketms/src/main/java/com/unicauca/openmarketms/domain/service/Delivery/DeliveryServiceImpl.java
    /**
     * Obtiene órdenes pendientes
     * 
     * @return lista de órdenes pendientes
     */
    @Override
    public List<DeliveryOrder> getAllPendingOrders() {
=======
    public List<DeliveryOrder> getAllPendingOrders(){
>>>>>>> a96d01912c183a229c30a0ada41b23de51953c82:openmarketms/src/main/java/com/unicauca/openmarketms/DeliveryOrder/domain/service/DeliveryServiceImpl.java
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
