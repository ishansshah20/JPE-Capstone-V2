package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Data
public class OrderShipping {

    @Id
    private String orderShippingId;

    @OneToOne
    private OrderInfo orderInfo;
    private String shippingAddressline1;
    private String shippingAddressline2;
    private String shippingCity;
    private String shippingState;
    private int shippingZip;
    private String shippingType;

    public OrderShipping(){
        this.orderShippingId = UUID.randomUUID().toString();
    }
}

