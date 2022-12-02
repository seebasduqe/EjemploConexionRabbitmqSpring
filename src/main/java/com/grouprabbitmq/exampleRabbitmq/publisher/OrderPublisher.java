package com.grouprabbitmq.exampleRabbitmq.publisher;


import com.grouprabbitmq.exampleRabbitmq.config.MessagingConfig;
import com.grouprabbitmq.exampleRabbitmq.dto.Ordering;
import com.grouprabbitmq.exampleRabbitmq.dto.OrderingStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Ordering ordering, @PathVariable("restaurantName") String restaurantName){
        ordering.setOrderId(UUID.randomUUID().toString());
        OrderingStatus orderingStatus = new OrderingStatus(ordering, "proccess", "order placed succesfully in " + restaurantName);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderingStatus);
        return "success !!";
    }


}
