package com.technokratos.kafkaproducer.controller;


import com.technokratos.kafkaproducer.config.KafkaProducerConfig.MessageDto;
import com.technokratos.kafkaproducer.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaMessageController {

    private final KafkaService kafkaService;

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody MessageDto dto) {
        kafkaService.send(dto);
    }

}
