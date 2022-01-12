package com.Egen.JPECapstone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class OrderPayment {

    @Id
    private String orderPaymentId;

    @OneToOne
    private OrderInfo orderInfo;

    private String paymentType;
    private String paymentMethod;
    private int paymentConfirmationNumber;
    private Timestamp paymentDate;
    private double paymentSubtotal;
    private String billingAddressline1;
    private String billingAddressline2;
    private String billingCity;
    private String billingState;
    private int billingZip;

    public OrderPayment(){
        this.orderPaymentId = UUID.randomUUID().toString();
    }
}
