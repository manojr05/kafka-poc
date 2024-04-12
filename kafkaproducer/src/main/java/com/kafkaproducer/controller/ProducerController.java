package com.kafkaproducer.controller;

import com.kafkaproducer.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProducerController {

    private final MessageProducer messageProducer;

    @PostMapping("/produce")
    public ResponseEntity<String> produceMessage(@RequestParam String message){
        log.info("Received message: {}", message);
      messageProducer.produceMessage(message);
      return ResponseEntity.ok(message);
    }


}
