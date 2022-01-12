package com.Egen.JPECapstone.dto;

import lombok.Data;

@Data
public class OrderShippingDTO{
    private String shippingAddressline1;
    private String shippingAddressline2;
    private String shippingCity;
    private String shippingState;
    private int shippingZip;
    private String shippingType;
}
