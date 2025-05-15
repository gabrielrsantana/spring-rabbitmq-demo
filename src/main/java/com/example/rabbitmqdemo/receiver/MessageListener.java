package com.example.rabbitmqdemo.receiver;

import com.example.rabbitmqdemo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void listen(String message) {
        System.out.println("Recebido: " + message);
    }
}
