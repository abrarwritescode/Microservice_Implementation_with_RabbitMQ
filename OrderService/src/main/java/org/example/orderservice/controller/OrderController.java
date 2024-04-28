package org.example.orderservice.controller;

import org.example.orderservice.Constants;
import org.example.orderservice.entity.Order;
import org.example.orderservice.entity.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}/{productId}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName, @PathVariable String productId ) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order Successfully Placed to " + restaurantName,""+productId);
        rabbitTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, orderStatus);
        return "success!!";
    }
}