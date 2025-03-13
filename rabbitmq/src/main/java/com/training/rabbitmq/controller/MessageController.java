package com.training.rabbitmq.controller;

import com.training.rabbitmq.service.RBMQProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.rabbitmq.dto.MessageDTO;

@RestController
@RequestMapping("/sample")
@AllArgsConstructor
public class MessageController {
    private final RBMQProducer rbmqProducer;

    @PostMapping
    public ResponseEntity<?> publishMessage(@RequestBody MessageDTO dto) throws Exception {
        System.out.println("Publish Data Message: " + dto.getMessage());
        System.out.println("Publish Data Remarks: " + dto.getRemarks());
        rbmqProducer.publishMessage(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestParam("message") String message) {
        System.out.println("Publish Message: " + message);
        rbmqProducer.publishMessage(message);
        return ResponseEntity.ok().build();
    }
}