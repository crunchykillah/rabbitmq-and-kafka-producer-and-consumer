package com.technokratos.kafkaproducer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technokratos.kafkaproducer.config.KafkaProducerConfig.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<Long, MessageDto> kafkaTemplate;

    @Override
    public void send(MessageDto dto) {
        kafkaTemplate.send("server.message_dto", dto);
        log.info("Message sended");
    }

}
