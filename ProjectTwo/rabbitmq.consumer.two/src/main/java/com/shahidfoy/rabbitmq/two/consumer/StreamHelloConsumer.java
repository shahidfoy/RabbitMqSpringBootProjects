package com.shahidfoy.rabbitmq.two.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class StreamHelloConsumer {

    private static final Logger log = LoggerFactory.getLogger(StreamHelloConsumer.class);

    @RabbitListener(queues = "s.hello")
    public void listenHello(String message) {
        log.info("Consuming from stream: {}", message);
    }
}
