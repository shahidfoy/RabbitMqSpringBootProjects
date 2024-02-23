package com.shahidfoy.rabbitmq.two.consumer;

import com.shahidfoy.rabbitmq.two.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class MultiplePrefetchConsumer {

    private static final Logger log = LoggerFactory.getLogger(MultiplePrefetchConsumer.class);

    @RabbitListener(queues = "q.transaction", concurrency = "2")
    public void listenTransaction(DummyMessage dummyMessage) throws InterruptedException {
        log.info("Consuming transaction: {}", dummyMessage.getContent());

        TimeUnit.SECONDS.sleep(1);
    }

    @RabbitListener(queues = "q.scheduler", concurrency = "2", containerFactory = "prefetchOneContainerFactory")
    public void listenScheduler(DummyMessage dummyMessage) throws InterruptedException {
        log.info("Consuming scheduler: {}", dummyMessage.getContent());

        TimeUnit.SECONDS.sleep(60);
    }
}
