package com.shahidfoy.rabbitmq.two.producer;

import com.shahidfoy.rabbitmq.two.entity.DummyMessage;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReliableProducer {

    private static final Logger log = LoggerFactory.getLogger(ReliableProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    private void registerCallback() {
        rabbitTemplate.setConfirmCallback((correlation, ack, reason) -> {
            if (correlation == null) {
                return;
            }
            if (ack) {
                log.info("message with correlation {} is published", correlation.getId());
            } else {
                log.warn("Invalid exchange, message with correlation {} is NOT published", correlation.getId());
            }
        });

        rabbitTemplate.setReturnsCallback(returnedMessage -> {
            log.info("Return callback");

            if (returnedMessage.getReplyText() != null && returnedMessage.getReplyText().equalsIgnoreCase("NO_ROUTE")) {
                var id = returnedMessage.getMessage().getMessageProperties().getHeader("spring_returned_message_correlation").toString();
                log.warn("Invalid routing key for id: {}", id);
            }
        });
    }

    public void sendDummyWithInvalidRoutingKey(DummyMessage message) {
        var correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("x.dummy", "invalidRoutingKey", message, correlationData);
    }

    public void sendDummyToInvalidExchange(DummyMessage message) {
        var correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("invalidExchange", "", message, correlationData);
    }
}
