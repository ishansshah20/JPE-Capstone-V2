package com.Egen.JPECapstone.service.impl;

import com.Egen.JPECapstone.dto.*;
import com.Egen.JPECapstone.model.*;
import com.Egen.JPECapstone.repository.*;
import com.Egen.JPECapstone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultOrderService implements OrderService {

    private static OrderInfoRepository orderInfoRepository;
    private static OrderShippingRepository orderShippingRepository;
    private static OrderCustomerRepository orderCustomerRepository;
    private static CustomerRepository customerRepository;
    private static OrderPaymentRepository orderPaymentRepository;
    private static OrderItemRepository orderItemRepository;

    @Autowired
    private DefaultOrderService(OrderInfoRepository orderInfoRepository,
                                OrderShippingRepository orderShippingRepository,
                                OrderCustomerRepository orderCustomerRepository,
                                CustomerRepository customerRepository,
                                OrderPaymentRepository orderPaymentRepository,
                                OrderItemRepository orderItemRepository){

        this.orderInfoRepository = orderInfoRepository;
        this.orderShippingRepository = orderShippingRepository;
        this.orderCustomerRepository = orderCustomerRepository;
        this.customerRepository = customerRepository;
        this.orderPaymentRepository = orderPaymentRepository;
        this.orderItemRepository = orderItemRepository;
    }

    private static List<OrderPayment> createOrderPayment(OrderInfo orderInfo, List<OrderPaymentDTO> orderPaymentDTOs){
        List<OrderPayment> orderPaymentsCreated = new ArrayList<>();
        for(OrderPaymentDTO orderPaymentDTO: orderPaymentDTOs){
            OrderPayment orderPayment = new OrderPayment();
            orderPayment.setOrderInfo(orderInfo);
            orderPayment.setPaymentType(orderPaymentDTO.getPaymentType());
            orderPayment.setPaymentMethod(orderPaymentDTO.getPaymentMethod());
            orderPayment.setPaymentConfirmationNumber(orderPaymentDTO.getPaymentConfirmationNumber());
            orderPayment.setPaymentDate(orderPaymentDTO.getPaymentDate());
            orderPayment.setPaymentSubtotal(orderPaymentDTO.getPaymentSubtotal());
            orderPayment.setBillingAddressline1(orderPaymentDTO.getBillingAddressline1());
            orderPayment.setBillingAddressline2(orderPaymentDTO.getBillingAddressline2());
            orderPayment.setBillingCity(orderPaymentDTO.getBillingCity());
            orderPayment.setBillingState(orderPaymentDTO.getBillingState());
            orderPayment.setBillingZip(orderPaymentDTO.getBillingZip());

            orderPaymentsCreated.add(orderPayment);
        }

        return orderPaymentsCreated;
    }

    //Change -> save to customer repository should be done in 'createOrder' method. Method chaining can be used
    private static OrderCustomer createOrderCustomer(OrderInfo orderInfo, OrderCustomerDTO orderCustomerDTO){
        String firstName = orderCustomerDTO.getFirstName();
        String lastName = orderCustomerDTO.getLastName();

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);

        OrderCustomer orderCustomerCreated = new OrderCustomer();
        orderCustomerCreated.setCustomer(customer);
        orderCustomerCreated.setOrderInfo(orderInfo);
        return orderCustomerCreated;
    }

    private static OrderShipping createOrderShipping(OrderInfo orderInfo, OrderShippingDTO orderShippingDTO){
        OrderShipping orderShippingCreated = new OrderShipping();
        orderShippingCreated.setOrderInfo(orderInfo);
        orderShippingCreated.setShippingAddressline1(orderShippingDTO.getShippingAddressline1());
        orderShippingCreated.setShippingAddressline2(orderShippingDTO.getShippingAddressline2());
        orderShippingCreated.setShippingCity(orderShippingDTO.getShippingCity());
        orderShippingCreated.setShippingState(orderShippingDTO.getShippingState());
        orderShippingCreated.setShippingType(orderShippingDTO.getShippingType());
        orderShippingCreated.setShippingZip(orderShippingDTO.getShippingZip());

        return orderShippingCreated;
    }

    private static List<OrderItem> createOrderItem(OrderInfo orderInfo, List<OrderItemDTO> orderItemDTOs){
        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemDTO orderItemDTO: orderItemDTOs){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderInfo(orderInfo);
            orderItem.setItemName(orderItemDTO.getName());
            orderItem.setQuantity(orderItemDTO.getQuantity());

            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private static OrderInfo createOrderInfo(OrderInfoDTO orderInfoDTO){
        OrderInfo orderInfoCreated = new OrderInfo();

        orderInfoCreated.setOrderStatus(orderInfoDTO.getOrderStatus());
        orderInfoCreated.setOrderCreatedDate(orderInfoDTO.getOrderCreatedDate());
        orderInfoCreated.setOrderModifiedDate(orderInfoDTO.getOrderModifiedDate());
        orderInfoCreated.setOrderSubtotal(orderInfoDTO.getOrderSubtotal());
        orderInfoCreated.setOrderTax(orderInfoDTO.getOrderTax());
        orderInfoCreated.setOrderShippingCharges(orderInfoDTO.getOrderShippingCharges());
        orderInfoCreated.setOrderTotal(orderInfoDTO.getOrderTotal());
        orderInfoCreated.setDeliveryAddressline1(orderInfoDTO.getDeliveryAddressline1());
        orderInfoCreated.setDeliveryAddressline2(orderInfoDTO.getDeliveryAddressline2());
        orderInfoCreated.setDeliveryCity(orderInfoDTO.getDeliveryCity());
        orderInfoCreated.setDeliveryState(orderInfoDTO.getDeliveryState());
        orderInfoCreated.setDeliveryZip(orderInfoDTO.getDeliveryZip());
        return orderInfoCreated;
    }

    @Override
    public OrderInfo createOrder(OrderInfoDTO orderInfoDTO) {
        OrderInfo orderInfoCreated = createOrderInfo(orderInfoDTO);
        orderInfoRepository.save(orderInfoCreated);
        orderShippingRepository.save(createOrderShipping(orderInfoCreated, orderInfoDTO.getOrderShipping()));
        orderCustomerRepository.save(createOrderCustomer(orderInfoCreated, orderInfoDTO.getOrderCustomer()));
        orderPaymentRepository.saveAll(createOrderPayment(orderInfoCreated, orderInfoDTO.getOrderPayment()));
        orderItemRepository.saveAll(createOrderItem(orderInfoCreated, orderInfoDTO.getOrderItems()));

        return orderInfoCreated;
    }

    @Override
    public Optional<OrderInfo> getOrder(String orderId) {
        return orderInfoRepository.findById(orderId);
    }

    @Override
    public Optional<OrderInfo> cancelOrder(String orderId) {
        Optional<OrderInfo> currentOrderInfo = orderInfoRepository.findById(orderId);
        currentOrderInfo.get().setOrderStatus("Cancelled");

        List<OrderPayment> orderPayments = orderPaymentRepository.getPaymentsByOrderId(orderId);

        for(OrderPayment orderPayment: orderPayments){
            double payment_subtotal = orderPayment.getPaymentSubtotal();
            orderPayment.setPaymentSubtotal(payment_subtotal * -1);
            orderPaymentRepository.save(orderPayment);
        }
        return currentOrderInfo;
    }

    @Override
    public List<OrderInfo> createBulkOrders(List<OrderInfoDTO> orderInfoDTOs) {
        List<OrderInfo> bulkOrderInfoCreated = new ArrayList<>();
        List<OrderShipping> bulkOrderShipping = new ArrayList<>();
        List<OrderCustomer> bulkOrderCustomer = new ArrayList<>();
        List<OrderPayment> bulkOrderPayment = new ArrayList<>();
        List<OrderItem> bulkOrderItem = new ArrayList<>();

        for(OrderInfoDTO orderInfoDTO: orderInfoDTOs){
            OrderInfo orderInfoCreated = createOrderInfo(orderInfoDTO);
            bulkOrderInfoCreated.add(orderInfoCreated);
            bulkOrderShipping.add(createOrderShipping(orderInfoCreated, orderInfoDTO.getOrderShipping()));
            bulkOrderCustomer.add(createOrderCustomer(orderInfoCreated, orderInfoDTO.getOrderCustomer()));
            bulkOrderPayment.addAll(createOrderPayment(orderInfoCreated, orderInfoDTO.getOrderPayment()));
            bulkOrderItem.addAll(createOrderItem(orderInfoCreated, orderInfoDTO.getOrderItems()));
        }

        orderInfoRepository.saveAll(bulkOrderInfoCreated);
        orderShippingRepository.saveAll(bulkOrderShipping);
        orderCustomerRepository.saveAll(bulkOrderCustomer);
        orderPaymentRepository.saveAll(bulkOrderPayment);
        orderItemRepository.saveAll(bulkOrderItem);

        return bulkOrderInfoCreated;
    }
}
