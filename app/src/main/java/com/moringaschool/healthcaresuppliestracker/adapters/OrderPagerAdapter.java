package com.moringaschool.healthcaresuppliestracker.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.healthcaresuppliestracker.fragments.TrackDetailsFragment;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.List;

public class OrderPagerAdapter extends FragmentPagerAdapter {

    List<Order> orders;

    public OrderPagerAdapter(@NonNull FragmentManager fm, int behaviour, List<Order> orders) {
        super(fm, behaviour);
        this.orders = orders;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return TrackDetailsFragment.newInstance(orders.get(position));
    }

    @Override
    public int getCount() {
        return orders.size();
    }
}
