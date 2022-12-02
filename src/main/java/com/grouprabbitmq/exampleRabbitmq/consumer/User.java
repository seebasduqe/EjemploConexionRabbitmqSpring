package com.grouprabbitmq.exampleRabbitmq.consumer;


import com.grouprabbitmq.exampleRabbitmq.config.MessagingConfig;
import com.grouprabbitmq.exampleRabbitmq.dto.OrderingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderingStatus orderingStatus){
        System.out.println("message received from queue: "+ orderingStatus);
    }

}
