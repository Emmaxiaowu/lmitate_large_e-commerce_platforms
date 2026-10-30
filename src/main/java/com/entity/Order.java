package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderId;
    private int userId;
    private BigDecimal totalPrice;
    private String status;
    private Date payTime;
    private String address;

    public Order(){}

    public Order(int orderId,int userId,BigDecimal totalPrice,String status,Date payTime,String address){
        this.orderId = orderId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = "未付款";
        this.payTime = payTime;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
