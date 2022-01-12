package com.Egen.JPECapstone.controller;

import com.Egen.JPECapstone.dto.OrderInfoDTO;
import com.Egen.JPECapstone.model.OrderInfo;
import com.Egen.JPECapstone.service.impl.DefaultOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class BulkOrdersController {

    private DefaultOrderService defaultOrderService;

    private BulkOrdersController(DefaultOrderService defaultOrderService){
        this.defaultOrderService = defaultOrderService;
    }

    @PostMapping("/save")
    public List<OrderInfo> saveOrder(@RequestBody List<OrderInfoDTO> orderInfoDTOs){
        return defaultOrderService.createBulkOrders(orderInfoDTOs);
    }

}
