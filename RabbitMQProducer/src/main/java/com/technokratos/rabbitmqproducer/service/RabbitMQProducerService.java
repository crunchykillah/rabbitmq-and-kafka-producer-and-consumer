package com.technokratos.rabbitmqproducer.service;

import com.technokratos.rabbitmqproducer.controller.RabbitMQController;

public interface RabbitMQProducerService {

    void sendMessage(String routingKey, RabbitMQController.EmailMessage message);
}
