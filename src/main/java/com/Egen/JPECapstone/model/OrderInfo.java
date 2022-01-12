package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class OrderInfo {

    @Id
    private String id;
    private String orderStatus;
    private Timestamp orderCreatedDate;
    private Timestamp orderModifiedDate;
    private double orderSubtotal;
    private double orderTax;
    private double orderShippingCharges;
    private double orderTotal;
    private String deliveryType;
    private String deliveryAddressline1;
    private String deliveryAddressline2;
    private String deliveryCity;
    private String deliveryState;
    private int deliveryZip;

    public OrderInfo(){
        this.id = UUID.randomUUID().toString();
    }
}
