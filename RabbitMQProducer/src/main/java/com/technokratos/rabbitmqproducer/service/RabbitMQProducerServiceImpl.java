package com.technokratos.rabbitmqproducer.service;

import com.technokratos.rabbitmqproducer.controller.RabbitMQController;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;
    @Override
    public void sendMessage(String routingKey, RabbitMQController.EmailMessage message) {
        rabbitTemplate.convertAndSend("emailExchange", routingKey, message);
    }

}
