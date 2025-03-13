package com.training.rabbitmq.configuration;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class QueueConfiguration {
    @Value("${rabbit.queue.name}")
    private String queueName;
    @Value("${rabbit.queue.exchange}")
    private String exchangeName;
    @Value("${rabbit.queue.routing-key}")
    private String routingKey;
    @Value("${spring.rabbitmq.port}")
    private int queuePort;

    @Bean
    public Queue queue() {
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-dead-letter-exchange", "training-sample-dead-letter-exchange");
//        return new Queue(queueName, true, false, false, args);
        return new Queue(queueName, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName, true, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
    }
}
