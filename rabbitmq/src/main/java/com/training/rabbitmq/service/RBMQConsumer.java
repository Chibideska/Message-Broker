package com.training.rabbitmq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.training.rabbitmq.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RBMQConsumer {

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void processMessage(String payload) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            MessageDTO dto = mapper.readValue(payload, MessageDTO.class);
            System.out.printf("Consuming Queue Data: Id %s, Name: %s, Remarks: %s %n", dto.getId(), dto.getMessage(), dto.getRemarks());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @RabbitListener(queues = "${rabbit.queue.name}")
//    public void processMessage(String payload) {
//        try{
//            ObjectMapper mapper = new ObjectMapper();
//            BLInfoDTO dto = mapper.readValue(payload, BLInfoDTO.class);
//            System.out.printf("Consuming Queue Data: Id %s, Name: %s, Remarks: %s %n", dto.getId(), dto.getBlNumber(), dto.getRemarks());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}