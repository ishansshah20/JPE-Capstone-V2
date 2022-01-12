package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class OrderItem {

    @Id
    private String orderItemId;

    @OneToOne
    private OrderInfo orderInfo;

    private String itemName;
    private int quantity;

    public OrderItem(){
        this.orderItemId = UUID.randomUUID().toString();
    }
}
