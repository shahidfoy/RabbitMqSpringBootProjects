package com.shahidfoy.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler.Context;
import com.shahidfoy.rabbitmq.consumer.stream.config.RabbitmqStreamConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class NumberConsumerFirst {

    private static final Logger log = LoggerFactory.getLogger(NumberConsumerFirst.class);

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "firstContainerFactoryOne")
    public void firstOne(Message message, Context context) {
        log.info("fist 1: {}, on offset {}", message.getBody(), context.offset());
    }

//    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "firstContainerFactoryTwo")
    public void firstTwo(Message message, Context context) {
        log.info("fist 2: {}, on offset {}", message.getBody(), context.offset());
    }

    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "firstContainerFactoryThree")
    public void firstThree(Message message, Context context) {
        log.info("fist 3: {}, on offset {}", message.getBody(), context.offset());

        context.storeOffset();
    }
}
