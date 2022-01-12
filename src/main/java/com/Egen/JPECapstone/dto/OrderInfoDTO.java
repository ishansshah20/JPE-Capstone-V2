package com.Egen.JPECapstone.dto;

import java.sql.Timestamp;
import java.util.List;


public class OrderInfoDTO {
    private String orderStatus;
    private Timestamp orderCreatedDate;
    private Timestamp orderModifiedDate;
    private double orderSubtotal;
    private double orderTax;

    private double orderShippingCharges;
    private double orderTotal;
    private OrderCustomerDTO orderCustomer;
    private List<OrderPaymentDTO> orderPayment;
    private OrderShippingDTO orderShipping;
    private List<OrderItemDTO> orderItems;
    private String deliveryType;
    private String deliveryAddressline1;
    private String deliveryAddressline2;
    private String deliveryCity;
    private String deliveryState;
    private int deliveryZip;

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(Timestamp orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    public Timestamp getOrderModifiedDate() {
        return orderModifiedDate;
    }

    public void setOrderModifiedDate(Timestamp orderModifiedDate) {
        this.orderModifiedDate = orderModifiedDate;
    }

    public double getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(double orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public double getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(double orderTax) {
        this.orderTax = orderTax;
    }

    public double getOrderShippingCharges() {
        return orderShippingCharges;
    }

    public void setOrderShippingCharges(double orderShippingCharges) {
        this.orderShippingCharges = orderShippingCharges;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public OrderCustomerDTO getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(OrderCustomerDTO orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public List<OrderPaymentDTO> getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(List<OrderPaymentDTO> orderPayment) {
        this.orderPayment = orderPayment;
    }

    public OrderShippingDTO getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(OrderShippingDTO orderShipping) {
        this.orderShipping = orderShipping;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getDeliveryAddressline1() {
        return deliveryAddressline1;
    }

    public void setDeliveryAddressline1(String deliveryAddressline1) {
        this.deliveryAddressline1 = deliveryAddressline1;
    }

    public String getDeliveryAddressline2() {
        return deliveryAddressline2;
    }

    public void setDeliveryAddressline2(String deliveryAddressline2) {
        this.deliveryAddressline2 = deliveryAddressline2;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public int getDeliveryZip() {
        return deliveryZip;
    }

    public void setDeliveryZip(int deliveryZip) {
        this.deliveryZip = deliveryZip;
    }
}

