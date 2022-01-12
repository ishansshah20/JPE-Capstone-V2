package com.Egen.JPECapstone.repository;

import com.Egen.JPECapstone.model.OrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderPaymentRepository extends JpaRepository<OrderPayment, String> {

    @Query("select p from OrderPayment p where p.orderInfo.id = :orderId")
    List<OrderPayment> getPaymentsByOrderId(@Param(value = "orderId") String orderId);
}
