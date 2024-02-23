package com.shahidfoy.rabbitmq.two.consumer;

import com.shahidfoy.rabbitmq.two.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class DummyConsumer {

    private static final Logger log = LoggerFactory.getLogger(DummyConsumer.class);

    @RabbitListener(queues = "q.dummy")
    public void listenDummy(DummyMessage dummyMessage) {
        log.info("{}", dummyMessage);
    }
}
