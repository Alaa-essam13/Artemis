package com.example.ecommerce.artemis;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    public void sendToQueue(String message) {
        jmsTemplate.convertAndSend("queue.demo", message);
    }

    public void sendToTopic(String message) {
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend("topic.demo", message);
        System.out.println("message sent to Topic: " + message);
    }


}
