package com.example.ecommerce.artemis;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageConsumers {

    @JmsListener(destination = "queue.demo")
    public void receiveQueueMessage(String message) {
        System.out.println("Queue consumer received message: " + message);
    }

    @JmsListener(destination = "topic.demo",containerFactory = "jmsListenerContainerFactory")
    public void receiveTopicMessage1(String message) {
        System.out.println("Topic consumer received message: " + message);
    }

    @JmsListener(destination = "topic.demo",containerFactory = "jmsListenerContainerFactory")
    public void receiveTopicMessage2(String message) {
        System.out.println("Topic consumer received message: " + message);
    }
}
