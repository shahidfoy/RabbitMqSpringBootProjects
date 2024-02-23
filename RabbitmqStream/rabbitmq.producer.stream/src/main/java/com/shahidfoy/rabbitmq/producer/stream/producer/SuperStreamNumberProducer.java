package com.shahidfoy.rabbitmq.producer.stream.producer;

import com.shahidfoy.rabbitmq.producer.stream.config.RabbitmqSuperStreamConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.rabbit.stream.producer.RabbitStreamTemplate;
import org.springframework.stereotype.Service;

//@Service
public class SuperStreamNumberProducer {

//    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    @Qualifier("superStreamNumberTemplate")
    private RabbitStreamTemplate rabbitStreamTemplate;

    public void sendNumberUsingRabbitTemplate(int start, int end) {
        for (int i = start; i < end; i++) {
            var str = "Number " + i;
            var routingKey = Integer.toString(i % RabbitmqSuperStreamConfig.SUPER_STREAM_NUMBER_PARTITIONS);
            rabbitTemplate.convertAndSend(RabbitmqSuperStreamConfig.SUPER_STREAM_NUMBER_NAME, routingKey, str);
        }

        System.out.printf("Sent super rabbit template %d to %d", start, (end - 1));
    }

    public void sendNumberUsingRabbitStreamTemplate(int start, int end) {
        for (int i = start; i < end; i++) {
            var str = "Number " + i;
            var message = rabbitStreamTemplate.messageBuilder()
                    .addData(str.getBytes())
                    .properties()
                    .messageId(i)
                    .messageBuilder().build();
            rabbitStreamTemplate.send(message);
        }

        System.out.printf("Sent super rabbit stream template %d to %d", start, (end - 1));
    }
}
