package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestsAdapter extends RecyclerView.Adapter<OrderRequestsAdapter.MyViewHolder> {

    private List<Order> orders;
    private List<Order> ordersAll;
    Context mContext;

    public OrderRequestsAdapter(List<Order> orders, Context mContext) {
        this.orders = orders;
        this.mContext = mContext;
        this.ordersAll = new ArrayList<>(orders);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.donor_list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.item_name.setText(order.getItemName());
        holder.item_quantity.setText("Quantity: " +  order.getItemQuantity());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item_name, hospital_name, item_quantity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.donor_item_name);
            hospital_name = itemView.findViewById(R.id.donor_item_hospital);
            item_quantity = itemView.findViewById(R.id.donor_item_quantity);
        }
    }
}
