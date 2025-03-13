package com.training.rabbitmq.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private long id;
    private String message;
    private String remarks;
}
