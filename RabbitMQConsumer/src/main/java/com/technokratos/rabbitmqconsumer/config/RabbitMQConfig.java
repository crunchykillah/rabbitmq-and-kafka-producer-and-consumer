package com.technokratos.rabbitmqconsumer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
    private final ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public DirectExchange emailExchange() {
        return new DirectExchange("emailExchange");
    }

    @Bean
    public Queue dotRuQueue() {
        return new Queue("dotRuQueue");
    }

    @Bean
    public Queue dotComQueue() {
        return new Queue("dotComQueue");
    }

    @Bean
    public Queue dotNetQueue() {
        return new Queue("dotNetQueue");
    }

    @Bean
    public Queue defaultQueue() {
        return new Queue("defaultQueue");
    }

    @Bean
    public Binding dotRuBinding(Queue dotRuQueue, DirectExchange exchange) {
        return BindingBuilder.bind(dotRuQueue).to(exchange).with("ru.routing.key");
    }

    @Bean
    public Binding dotComBinding(Queue dotComQueue, DirectExchange exchange) {
        return BindingBuilder.bind(dotComQueue).to(exchange).with("com.routing.key");
    }

    @Bean
    public Binding dotNetBinding(Queue dotNetQueue, DirectExchange exchange) {
        return BindingBuilder.bind(dotNetQueue).to(exchange).with("net.routing.key");
    }

    @Bean
    public Binding defaultBinding(Queue defaultQueue, DirectExchange exchange) {
        return BindingBuilder.bind(defaultQueue).to(exchange).with("default.routing.key");
    }

}