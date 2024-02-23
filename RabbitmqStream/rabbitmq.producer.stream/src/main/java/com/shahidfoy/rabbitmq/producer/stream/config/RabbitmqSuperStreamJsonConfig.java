package com.shahidfoy.rabbitmq.producer.stream.config;

import com.rabbitmq.stream.Environment;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.config.SuperStream;
import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;

@Configuration
public class RabbitmqSuperStreamJsonConfig {

    public static final String SUPER_STREAM_INVOICE_NAME = "s.super.invoice";
    public static final int SUPER_STREAM_INVOICE_PARTITIONS = 3;

    @Bean
    SuperStream superStreamInvoice() {
        return new SuperStream(SUPER_STREAM_INVOICE_NAME, SUPER_STREAM_INVOICE_PARTITIONS);
    }

    @Bean(name = "superStreamInvoiceTemplate")
    RabbitStreamTemplate superStreamInvoiceTemplate(Environment environment, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        var template = new RabbitStreamTemplate(environment, SUPER_STREAM_INVOICE_NAME);
        template.setMessageConverter(jackson2JsonMessageConverter);
        template.setSuperStreamRouting(message -> {
            return message.getProperties().getMessageIdAsString();
        });

        return template;
    }

}
