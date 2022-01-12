package com.Egen.JPECapstone.service;

import com.Egen.JPECapstone.dto.OrderInfoDTO;
import com.Egen.JPECapstone.model.OrderInfo;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<OrderInfo> getOrder(String id);
    OrderInfo createOrder(OrderInfoDTO orderInfoDTO);
    Optional<OrderInfo> cancelOrder(String orderId);
    List<OrderInfo> createBulkOrders(List<OrderInfoDTO> orderInfoDTOs);
}
