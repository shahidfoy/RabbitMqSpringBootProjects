package com.shahidfoy.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler.Context;
import com.shahidfoy.rabbitmq.consumer.stream.config.RabbitmqStreamConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class NumberConsumerNext {

    private static final Logger log = LoggerFactory.getLogger(NumberConsumerNext.class);

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "nextContainerFactoryOne")
    public void nextOne(Message message, Context context) {
        log.info("next 1: {}, on offset {}", message.getBody(), context.offset());
    }

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "nextContainerFactoryTwo")
    public void nextTwo(Message message, Context context) {
        log.info("next 2: {}, on offset {}", message.getBody(), context.offset());
    }
}
