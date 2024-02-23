package com.shahidfoy.rabbitmq.two.consumer;

import com.shahidfoy.rabbitmq.two.entity.InvoiceCancelledMessage;
import com.shahidfoy.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.shahidfoy.rabbitmq.two.entity.InvoicePaidMessage;
import com.shahidfoy.rabbitmq.two.entity.PaymentCancelStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

//@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    private static final Logger log = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message) {
        log.info("Invoice created: {}", message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message) {
        log.info("Invoice paid: {}", message);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message) {
        log.info("Default handler: {}", message);
    }

    @RabbitHandler
    @SendTo("x.invoice.cancel/")
    public PaymentCancelStatus handleInvoiceCancelled(InvoiceCancelledMessage message) {
        var randomStatus = ThreadLocalRandom.current().nextBoolean();
        return new PaymentCancelStatus(randomStatus, LocalDate.now(), message.getInvoiceNumber());
    }
}
