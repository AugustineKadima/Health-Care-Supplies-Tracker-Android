package com.moringaschool.healthcaresuppliestracker.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class DeliveredViewModel extends ViewModel {

    private final MutableLiveData<HashMap<String, String>> delivered = new MutableLiveData<>();
    private HashMap<String,String> deliveredItems = new HashMap<>();


    public void setData(String itemName, String itemQuantity, String itemDescription, String donorEmail){
        deliveredItems.put("itemName",itemName);
        deliveredItems.put("itemQuantity",itemQuantity);
        deliveredItems.put("itemDescription",itemDescription);
        deliveredItems.put("donorEmail",donorEmail);
        delivered.setValue(deliveredItems);
    }

    public LiveData<HashMap<String,String>> getDelivered(){
        return delivered;
    }
}

