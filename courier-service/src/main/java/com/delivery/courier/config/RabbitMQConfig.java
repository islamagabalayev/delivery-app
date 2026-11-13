package com.delivery.courier.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "order.exchange";

    public static final String ASSIGNED_QUEUE = "courier.order-assigned.queue";
    public static final String DELIVERED_QUEUE = "courier.order-delivered.queue";

    public static final String ASSIGNED_KEY = "order.assigned";
    public static final String DELIVERED_KEY = "order.delivered";

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue assignedQueue() {
        return new Queue(ASSIGNED_QUEUE);
    }

    @Bean
    public Queue deliveredQueue() {
        return new Queue(DELIVERED_QUEUE);
    }

    @Bean
    public Binding assignedBinding(Queue assignedQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(assignedQueue).to(orderExchange).with(ASSIGNED_KEY);
    }

    @Bean
    public Binding deliveredBinding(Queue deliveredQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(deliveredQueue).to(orderExchange).with(DELIVERED_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}