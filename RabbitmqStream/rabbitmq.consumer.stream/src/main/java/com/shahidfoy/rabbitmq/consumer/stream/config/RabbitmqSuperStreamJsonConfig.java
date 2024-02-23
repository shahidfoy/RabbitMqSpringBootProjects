package com.shahidfoy.rabbitmq.consumer.stream.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;
import com.shahidfoy.rabbitmq.consumer.stream.entity.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.listener.StreamListenerContainer;

import java.util.concurrent.TimeUnit;

@Configuration
public class RabbitmqSuperStreamJsonConfig {

    private static final Logger log = LoggerFactory.getLogger(RabbitmqSuperStreamConfig.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Bean(name = "superStreamInvoiceContainer")
    StreamListenerContainer superStreamInvoiceContainer() {
        var environment = Environment.builder().maxConsumersByConnection(1).build();
        var container = new StreamListenerContainer(environment);

        container.setConsumerCustomizer((id, builder) -> builder.offset(OffsetSpecification.first()));
        container.superStream("s.super.invoice", "my-super-stream-invoice-consumer");
        container.setupMessageListener(message -> {
            try {
                var invoice = objectMapper.readValue(message.getBody(), Invoice.class);
                log.info("Invoice is: {}", invoice);
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return container;
    }
}
