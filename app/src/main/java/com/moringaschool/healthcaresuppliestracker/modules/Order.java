package com.moringaschool.healthcaresuppliestracker.modules;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Order {

    private String itemName;
    private String itemQuantity;
    private String itemDescription;
    private String donorEmail;
    private String orderDate;

    public Order(){

    }

    public Order(String itemName, String itemQuantity, String itemDescription, String donorEmail, String orderDate) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.donorEmail = donorEmail;
        this.orderDate = orderDate;
    }

    public static void clear() {
    }

    public static void addAll(List values) {
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
