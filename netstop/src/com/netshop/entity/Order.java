package com.netshop.entity;

import java.util.HashSet;
import java.util.Set;

public class Order {
    private int orderId;
    private User user;
    private String orderDate;
    private String orderStatus;
    private Deliveryinfo deInfo;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Deliveryinfo getDeInfo() {
        return deInfo;
    }

    public void setDeInfo(Deliveryinfo deInfo) {
        this.deInfo = deInfo;
    }

    public Set getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set orderItems) {
        this.orderItems = orderItems;
    }

    private Set orderItems = new HashSet();

    public Order(){
        super();
    }
    public Order(int orderId, User user, String orderDate, String orderStatus,Deliveryinfo deInfo)
    {
        super();
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.deInfo = deInfo;
    }
    public Order(int orderId, User user, String orderDate, String orderStatus)
    {
        super();
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
    public Order(int orderId, User user, String orderDate, String orderStatus,Deliveryinfo deInfo, Set orderItems)
    {
        super();
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.deInfo = deInfo;
        this.orderItems = orderItems;
    }

    public Order(User user, String orderDate, Deliveryinfo deInfo) {
        super();
        this.orderDate = orderDate;
        this.user = user;
        this.deInfo = deInfo;
    }



}
