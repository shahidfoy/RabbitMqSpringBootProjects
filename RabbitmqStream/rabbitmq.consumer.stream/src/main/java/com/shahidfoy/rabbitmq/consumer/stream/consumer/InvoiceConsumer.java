package com.shahidfoy.rabbitmq.consumer.stream.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.MessageHandler;
import com.shahidfoy.rabbitmq.consumer.stream.config.RabbitmqStreamJsonConfig;
import com.shahidfoy.rabbitmq.consumer.stream.entity.Invoice;
import org.apache.qpid.proton.amqp.messaging.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InvoiceConsumer {

    public static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

//    @RabbitListener(queues = RabbitmqStreamJsonConfig.STREAM_INVOICE)
    public void listenDefault(Invoice message) {
        log.info("listen default: {}", message);
    }

//    @RabbitListener(queues = RabbitmqStreamJsonConfig.STREAM_INVOICE, containerFactory = "invoiceContainerFactoryOne")
    public void listenWithContainerFactoryOne(String message) throws JsonProcessingException {
        log.info("listenWithContainerFactoryOne receive JSON string: {}", message);
        var invoice = objectMapper.readValue(message, Invoice.class);
        log.info("listenWithContainerFactoryOne: {}", invoice);
    }

//    @RabbitListener(queues = RabbitmqStreamJsonConfig.STREAM_INVOICE, containerFactory = "invoiceContainerFactoryTwo")
    public void listenWithContainerFactoryTwo(Message message, MessageHandler.Context context) throws IOException {
        var data = (Data) message.getBody();
        log.info("listenWithContainerFactoryTwo receive JSON string: {}", message);
        var invoice = objectMapper.readValue(data.getValue().getArray(), Invoice.class);
        log.info("listenWithContainerFactoryTwo: {}", invoice);
    }
}
