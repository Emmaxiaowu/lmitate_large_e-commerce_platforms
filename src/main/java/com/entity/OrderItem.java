package com.entity;

import java.math.BigDecimal;

public class OrderItem {
    private int ItemId;
    private int orderId;
    private int productId;
    private int quantity;
    private BigDecimal price;

    public OrderItem(){}

    public OrderItem(int itemId,int orderId,int productId,int quantity,BigDecimal price,String category){
        this.ItemId = itemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        this.ItemId = itemId;
    }
}
