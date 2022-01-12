package com.Egen.JPECapstone.repository;

import com.Egen.JPECapstone.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
