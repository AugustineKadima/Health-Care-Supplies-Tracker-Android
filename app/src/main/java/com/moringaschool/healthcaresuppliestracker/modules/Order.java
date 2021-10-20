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

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
