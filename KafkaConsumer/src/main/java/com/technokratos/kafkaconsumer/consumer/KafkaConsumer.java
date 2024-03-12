package com.technokratos.kafkaconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technokratos.kafkaconsumer.config.KafkaConsumerConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(id = "Message", topics = {"server.message_dto"}, containerFactory = "singleFactory")
    public void consume(KafkaConsumerConfig.MessageDto dto) {
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString(KafkaConsumerConfig.MessageDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
