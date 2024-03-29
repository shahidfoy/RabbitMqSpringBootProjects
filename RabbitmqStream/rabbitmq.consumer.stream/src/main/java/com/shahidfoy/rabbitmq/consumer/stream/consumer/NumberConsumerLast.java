package com.shahidfoy.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler.Context;
import com.shahidfoy.rabbitmq.consumer.stream.config.RabbitmqStreamConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class NumberConsumerLast {

    private static final Logger log = LoggerFactory.getLogger(NumberConsumerLast.class);

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "lastContainerFactoryOne")
    public void lastOne(Message message, Context context) {
        log.info("last 1: {}, on offset {}", message.getBody(), context.offset());
    }

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "lastContainerFactoryTwo")
    public void lastTwo(Message message, Context context) {
        log.info("last 2: {}, on offset {}", message.getBody(), context.offset());
    }
}
