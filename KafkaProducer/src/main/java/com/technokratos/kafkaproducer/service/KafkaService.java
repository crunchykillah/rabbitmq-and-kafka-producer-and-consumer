package com.technokratos.kafkaproducer.service;

import com.technokratos.kafkaproducer.config.KafkaProducerConfig.MessageDto;

public interface KafkaService {

    public void send(MessageDto dto);

}
