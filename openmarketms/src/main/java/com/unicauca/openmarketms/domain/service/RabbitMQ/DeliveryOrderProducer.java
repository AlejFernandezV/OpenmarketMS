package com.unicauca.openmarketms.domain.service.RabbitMQ;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.unicauca.openmarketms.domain.entity.Delivery.DeliveryOrder;
import com.unicauca.openmarketms.utils.Constants;

@Component
public class DeliveryOrderProducer {
    ConnectionFactory factory;
    
    @Autowired
    public DeliveryOrderProducer() {
        factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
    }

    public void sendMessage(DeliveryOrder deliveryOrder)throws Exception{
        try (
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
			) 
		{
            channel.exchangeDeclare(Constants.EXCHANGE_NAME2, Constants.EXCHANGE_TYPE);

			String message = deliveryOrder.getId()+","+deliveryOrder.getDeliver().getId()
            +","+deliveryOrder.getProduct().getId()
            +","+deliveryOrder.getQuantity()
            +","+deliveryOrder.getStatus();
             
			System.out.println("Informacion a enviar" + deliveryOrder.getId()
            +", Id Deliver: "+deliveryOrder.getDeliver().getId()
            +", Id Product: "+deliveryOrder.getProduct().getId()
            +", Cantidad: "+deliveryOrder.getQuantity()
            +", Status: "+deliveryOrder.getStatus());

			if(message.length() < 0){
				message = "default message";
			} 

            channel.basicPublish(Constants.EXCHANGE_NAME2,"",null,message.getBytes(StandardCharsets.UTF_8));
            
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
