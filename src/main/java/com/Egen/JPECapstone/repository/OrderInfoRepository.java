package com.Egen.JPECapstone.repository;

import com.Egen.JPECapstone.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, String> {

}
