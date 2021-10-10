package com.moringaschool.healthcaresuppliestracker.modules;

public class Order {

    private String itemName;
    private String itemQuantity;
    private String itemDescription;
    private String donorEmail;

    public Order(){

    }

    public Order(String itemName, String itemQuantity, String itemDescription, String donorEmail) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
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
}
