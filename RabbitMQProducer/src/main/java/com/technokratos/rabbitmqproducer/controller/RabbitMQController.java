package com.technokratos.rabbitmqproducer.controller;

import com.technokratos.rabbitmqproducer.service.RabbitMQProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


@RestController
@RequestMapping("api/rabbit")
@RequiredArgsConstructor
@Slf4j
public class RabbitMQController {

    private final RabbitMQProducerService rabbitMQProducerService;

    @PostMapping("/message")
    public void sendMessageToRabbit(@RequestBody EmailMessage message) {
        String routingKey;
        if (message.email.endsWith("ru")) {
            routingKey = "ru.routing.key";
        } else if (message.email.endsWith("com")) {
            routingKey = "com.routing.key";
        } else if (message.email.endsWith("net")) {
            routingKey = "net.routing.key";
        } else {
            routingKey = "default.routing.key";
        }
        rabbitMQProducerService.sendMessage(routingKey, message);
        log.info("message with routing key: " + routingKey + " sent");
    }

    public record EmailMessage(
            String message,
            String email) implements Serializable {
    }

}
