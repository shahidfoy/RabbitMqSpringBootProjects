package com.shahidfoy.rabbitmq.two.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RabbitmqScheduler {

    private static final Logger log = LoggerFactory.getLogger(RabbitmqScheduler.class);

    @Autowired
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    @Scheduled(cron = "0 0 23 * * *")
    public void stopAll() {
        rabbitListenerEndpointRegistry.getListenerContainers().forEach(
                container -> {
                    log.info("Stopping container {}", container);
                    container.stop();
                }
        );
    }

    @Scheduled(cron = "1 0 0 * * *")
    public void startAll() {
        rabbitListenerEndpointRegistry.getListenerContainers().forEach(
                container -> {
                    log.info("Starting container {}", container);
                    container.start();
                }
        );
    }
}
