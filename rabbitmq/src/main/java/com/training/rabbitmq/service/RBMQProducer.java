package com.training.rabbitmq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.rabbitmq.configuration.QueueConfiguration;
import com.training.rabbitmq.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RBMQProducer {
    private final QueueConfiguration queueConfiguration;
    private final RabbitTemplate rabbitTemplate;

    public void publishMessage(String message) {
        rabbitTemplate.convertAndSend(queueConfiguration.getExchangeName(), queueConfiguration.getRoutingKey(), message);
    }

    public void publishMessage(MessageDTO messageDTO) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String payload;
        try {
            payload = mapper.writeValueAsString(messageDTO);
            rabbitTemplate.convertAndSend(queueConfiguration.getExchangeName(), queueConfiguration.getRoutingKey(), payload);
        } catch (JsonProcessingException e) {
            throw new Exception();
        }
    }
}
