package com.moringaschool.healthcaresuppliestracker.modules;

import org.parceler.Parcel;

@Parcel
public class Order {

    private String itemName;
    private String itemQuantity;
    private String itemDescription;
    private String donorEmail;
    private String orderDate;
    private String status;

    public Order(){

    }

    public Order(String itemName, String itemQuantity, String itemDescription, String donorEmail, String orderDate, String status) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public String getOrderDate() {
        return orderDate;
    }
}
