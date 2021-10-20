package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.interfaces.ItemClickListener;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.List;

public class DispatchesAdapter extends RecyclerView.Adapter<DispatchesAdapter.ViewHolder> {

    private List<Order> orders;
    private List<Order> ordersAll;
    Context mContext;
    ItemClickListener clickListener;

    public DispatchesAdapter(List<Order> orders, Context mContext, ItemClickListener clickListener) {
        this.orders = orders;
        this.ordersAll = ordersAll;
        this.mContext = mContext;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public DispatchesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dispatches_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DispatchesAdapter.ViewHolder holder, int position) {
        Order order = orders.get(position);
//        holder.hospitalName.setText(order.getItemName());
        holder.productName.setText(order.getItemName());
        holder.quantity.setText(order.getItemQuantity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                clickListener.onItemClick(order);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        TextView productName, hospitalName, quantity;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            productName = itemView.findViewById(R.id.dispatches_list_item_name);
            hospitalName = itemView.findViewById(R.id.dispatches_list_item_hospital);
            quantity = itemView.findViewById(R.id.dispatches_list_item_quantity);
        }
    }
}
