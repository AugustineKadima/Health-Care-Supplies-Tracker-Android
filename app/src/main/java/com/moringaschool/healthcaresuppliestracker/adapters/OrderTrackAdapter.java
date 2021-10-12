package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.interfaces.ItemClickListener;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderTrackAdapter extends RecyclerView.Adapter<OrderTrackAdapter.ViewHolder> {

    Context mContext;
    private List<Order> orders;
    private List<Order> ordersAll;
    ItemClickListener clickListener;

    public OrderTrackAdapter(List<Order> orders, Context mContext, ItemClickListener clickListener) {
        this.orders = orders;
        this.mContext = mContext;
        this.ordersAll = new ArrayList<>(orders);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public OrderTrackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.track_order_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderTrackAdapter.ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.item_name.setText(order.getItemName());
        holder.item_quantity.setText(order.getItemQuantity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(order);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item_name, item_quantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.track_item_name);
            item_quantity = itemView.findViewById(R.id.track_item_quantity);
        }
    }
}
