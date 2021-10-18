package com.moringaschool.healthcaresuppliestracker.interfaces;

import android.view.Menu;

import com.moringaschool.healthcaresuppliestracker.modules.Order;

public interface ItemClickListener {
    public void onItemClick(Order order);

    boolean onCreateOptionsMenu(Menu menu);
}
