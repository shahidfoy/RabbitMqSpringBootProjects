package com.shahidfoy.rabbitmq.consumer.stream.consumer;

import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler.Context;
import com.shahidfoy.rabbitmq.consumer.stream.config.RabbitmqStreamConfig;
import org.apache.qpid.proton.amqp.messaging.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class NumberConsumerSingleActive {

    @RabbitListener(queues = RabbitmqStreamConfig.STREAM_NUMBER, containerFactory = "singleActiveContainerFactoryOne")
    private void singleActiveOne(Message message, Context context) throws InterruptedException {
        var data = (Data) message.getBody();
        var logStr = String.format("single active 1: %s, offset: %d", data.getValue(), context.offset());
        System.out.println(logStr);

        TimeUnit.MICROSECONDS.sleep(5000);
    }
}
