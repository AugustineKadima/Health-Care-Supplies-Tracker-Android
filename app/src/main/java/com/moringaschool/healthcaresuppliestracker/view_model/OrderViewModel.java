package com.moringaschool.healthcaresuppliestracker.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderViewModel extends ViewModel {
    private final MutableLiveData<HashMap<String, String>> order = new MutableLiveData<>();
    private HashMap<String,String> formData = new HashMap<>();


    public void setData( String itemName, String itemQuantity, String itemDescription, String donorEmail, String orderDate, String status){
        formData.put("itemName",itemName);
        formData.put("itemQuantity",itemQuantity);
        formData.put("itemDescription",itemDescription);
        formData.put("donorEmail",donorEmail);
        formData.put("orderDate: ", orderDate);
        formData.put("status", status);
        order.setValue(formData);
    }

    public LiveData<HashMap<String,String>> getOrder(){
        return order;
    }
}
