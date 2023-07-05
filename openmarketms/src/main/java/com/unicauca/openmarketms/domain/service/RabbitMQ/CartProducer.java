package com.unicauca.openmarketms.domain.service.RabbitMQ;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import com.unicauca.openmarketms.domain.entity.Cart.Cart;
import com.unicauca.openmarketms.utils.Constants;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Productor de mensajes para RabbitMQ")
@Component
public class CartProducer {
    ConnectionFactory factory;

    @Autowired
    public CartProducer() {
        factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
    }

    /**
     * Envía un mensaje a la exchange "EXCHANGE_CARTS"(RabbitMQ).
     *
     * @param cart El carrito del cual se enviara la informacion como mensaje.
     * @throws Exception si ocurre un error durante el envío del mensaje.
     */
    public void sendMessage(Cart cart)throws Exception{
        try (
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
			) 
		{
            channel.exchangeDeclare(Constants.EXCHANGE_NAME1, Constants.EXCHANGE_TYPE);

			String message = cart.getId()+""; 
			System.out.println("Informacion a enviar: Id Carrito: "+cart.getId());

			if(message.length() < 0){
				message = "default message";
			} 

            channel.basicPublish(Constants.EXCHANGE_NAME1,"",null,message.getBytes(StandardCharsets.UTF_8));
            
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
