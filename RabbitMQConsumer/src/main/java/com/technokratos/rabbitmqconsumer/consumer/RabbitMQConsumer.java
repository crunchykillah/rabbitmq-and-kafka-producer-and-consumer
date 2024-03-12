package com.technokratos.rabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "dotComQueue")
    public void listenDotComQueue(EmailMessage message) {
        System.out.printf("Received a message from dotComQueue : %s \n", message.email);
    }

    @RabbitListener(queues = "dotNetQueue")
    public void listenDotNetQueue(EmailMessage message) {
        System.out.printf("Received a message from dotNetQueue : %s \n", message.email);
    }

    @RabbitListener(queues = "defaultQueue")
    public void listenDefaultQueue(EmailMessage message) {
        System.out.printf("Received a message from defaultQueue : %s \n", message.email);
    }

    @RabbitListener(queues = "dotRuQueue")
    public void listenDotRuQueue(EmailMessage message) {
        System.out.printf("Received a message from dotRuQueue : %s \n", message.email);
    }

    public record EmailMessage(
            String message,
            String email) implements Serializable {
    }

}
