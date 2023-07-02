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
    private final static String EXCHANGE_NAME = "EXCHANGE_CARTS";
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
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);

			String message = deliveryOrder.getId()+""; 
			System.out.println("Informacion a enviar, id de la orden: " + deliveryOrder.getId());

			if(message.length() < 0){
				message = "default message";
			} 

            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes(StandardCharsets.UTF_8));
            
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
