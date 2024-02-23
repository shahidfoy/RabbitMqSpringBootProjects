package com.shahidfoy.rabbitmq.two.consumer;

import com.shahidfoy.rabbitmq.two.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class DummyPrefetchConsumer {

    private static final Logger log = LoggerFactory.getLogger(DummyPrefetchConsumer.class);

    @RabbitListener(queues = "q.dummy", concurrency = "2")
    public void listenDummy(DummyMessage dummyMessage) throws InterruptedException {

        log.info("Message is {}", dummyMessage);
        TimeUnit.SECONDS.sleep(20);
    }
}
