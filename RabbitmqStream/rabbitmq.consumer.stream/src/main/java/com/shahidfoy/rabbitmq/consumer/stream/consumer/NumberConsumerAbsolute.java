package com.shahidfoy.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler.Context;
import com.shahidfoy.rabbitmq.consumer.stream.config.RabbitmqStreamConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class NumberConsumerAbsolute {

    private static final Logger log = LoggerFactory.getLogger(NumberConsumerAbsolute.class);

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "absoluteContainerFactoryOne")
    public void absoluteOne(Message message, Context context) {
        log.info("absolute 1: {}, on offset {}", message.getBody(), context.offset());
    }

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "absoluteContainerFactoryTwo")
    public void absoluteTwo(Message message, Context context) {
        log.info("absolute 2: {}, on offset {}", message.getBody(), context.offset());
    }
}
