package com.moringaschool.healthcaresuppliestracker.modules;

public class Delivered {
    private String itemName;
    private String itemQuantity;
    private String itemDescription;
    private String donorEmail;
    private String orderDate;
    private String deliveryDate;

    public Delivered(){}

    public Delivered(String itemName, String itemQuantity, String itemDescription, String donorEmail, String deliveryDate) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
        this.deliveryDate = deliveryDate;
    }

    public Delivered(String itemName, String itemQuantity, String itemDescription, String donorEmail, String orderDate, String deliveryDate) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
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

    public String getDeliveryDate() {
        return deliveryDate;
    }
}
