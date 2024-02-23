package com.shahidfoy.rabbitmq.two.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("x.another-dummy", true, false, null);
//    }
//
////    HeadersExchange headersExchange() {
////        return new HeadersExchange()
////    }
//
////    TopicExchange topicExchange() {
////        return new TopicExchange()
////    }
//
////    DirectExchange directExchange() {
////        return new DirectExchange()
////    }

//    @Bean
//    Queue queue() {
//        return new Queue("q.another-dummy");
//    }
//
//    @Bean
//    Binding binding() {
////        return new Binding("q.another-dummy", Binding.DestinationType.QUEUE, "x.another-dummy", "", null);
////        return BindingBuilder.bind((queue())).to(new DirectExchange("x.direct")).with("routingKey");
//        return BindingBuilder.bind((queue())).to(fanoutExchange());
//    }

    @Bean
    Declarables createRabbitmqSchema() {
        return new Declarables(
                new FanoutExchange("x.another-dummy", true, false, null),
                new Queue("q.another-dummy"),
                new Binding("q.another-dummy", Binding.DestinationType.QUEUE, "x.another-dummy", "", null)
        );
    }
}
