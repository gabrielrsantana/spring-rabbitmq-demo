package com.example.rabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "minha-fila";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, false); //se estiver false, apaga a mensagem da fila depois de lido
    }
}

