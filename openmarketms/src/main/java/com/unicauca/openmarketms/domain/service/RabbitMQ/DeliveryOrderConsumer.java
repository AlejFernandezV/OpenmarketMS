package com.unicauca.openmarketms.domain.service.RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.unicauca.openmarketms.utils.Constants;

public class DeliveryOrderConsumer {
    
    public void consumeMessage() throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(Constants.EXCHANGE_NAME2, Constants.EXCHANGE_TYPE);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, Constants.EXCHANGE_NAME2, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(" Processing message...");
            //TO DO
            //objDelivery.procesarMensaje(message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
	}
}
