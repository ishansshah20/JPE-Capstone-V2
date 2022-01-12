package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class OrderCustomer {

    @Id
    private String orderCustomerId;

    @OneToOne
    private OrderInfo orderInfo;

    @OneToOne
    private Customer customer;

    public OrderCustomer(){
        this.orderCustomerId = UUID.randomUUID().toString();
    }
}
