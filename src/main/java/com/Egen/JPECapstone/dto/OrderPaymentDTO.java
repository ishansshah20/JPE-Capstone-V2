package com.Egen.JPECapstone.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderPaymentDTO {
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
}