package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.fragments.ItemRequestFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.TrackDetailsFragment;
import com.moringaschool.healthcaresuppliestracker.interfaces.ItemClickListener;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestsAdapter extends RecyclerView.Adapter<OrderRequestsAdapter.MyViewHolder> {

    private List<Order> orders;
    private List<Order> ordersAll;
    Context mContext;
    ItemClickListener clickListener;

    public OrderRequestsAdapter(List<Order> orders, Context mContext, ItemClickListener clickListener) {
        this.orders = orders;
        this.mContext = mContext;
        this.clickListener = clickListener;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("_quantity", order.getItemQuantity());
                bundle.putString("_donor_email", order.getDonorEmail());
                bundle.putString("_item_name", order.getItemName());
                bundle.putString("status", order.getStatus());
                bundle.putString("orderDate", order.getOrderDate());
                ItemRequestFragment itemRequestFragment = new ItemRequestFragment();
                itemRequestFragment.setArguments(bundle);

//                clickListener.onItemClick(order);
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_donor_pages, itemRequestFragment).addToBackStack(null).commit();

            }
        });
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
