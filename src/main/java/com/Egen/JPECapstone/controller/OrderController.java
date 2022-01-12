package com.Egen.JPECapstone.controller;

import com.Egen.JPECapstone.dto.OrderInfoDTO;
import com.Egen.JPECapstone.model.OrderInfo;
import com.Egen.JPECapstone.service.impl.DefaultOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private DefaultOrderService defaultOrderService;

    private OrderController(DefaultOrderService defaultOrderService){
        this.defaultOrderService = defaultOrderService;
    }

    @GetMapping(path = "/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/byId")
    public Optional<OrderInfo> getOrderById(@RequestParam("id") String orderId){
        return defaultOrderService.getOrder(orderId);
    }

    @PostMapping("/save")
    public OrderInfo saveOrder(@RequestBody OrderInfoDTO orderInfoDTO){
        return defaultOrderService.createOrder(orderInfoDTO);
    }

    @PostMapping("/cancel")
    public Optional<OrderInfo> cancelOrder(@RequestParam("id") String orderId){
        return defaultOrderService.cancelOrder(orderId);
    }

}
