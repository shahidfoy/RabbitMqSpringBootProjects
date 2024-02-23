package com.shahidfoy.rabbitmq.two.consumer;

import com.shahidfoy.rabbitmq.two.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class SingleActiveConsumer {

    private static final Logger log = LoggerFactory.getLogger(SingleActiveConsumer.class);

    @RabbitListener(queues = "q.single", concurrency = "5")
    public void listenDummy(DummyMessage message) throws InterruptedException {
        log.info("{}", message);
        TimeUnit.SECONDS.sleep(1);
    }
}
