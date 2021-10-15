package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.modules.Delivered;

import java.util.List;

public class DeliveredItemsAdapter extends RecyclerView.Adapter<DeliveredItemsAdapter.ViewHolder> {

    List<Delivered> deliveredList;
    Context mContext;

    public DeliveredItemsAdapter(List<Delivered> deliveredList, Context mContext) {
        this.deliveredList = deliveredList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DeliveredItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.stock_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveredItemsAdapter.ViewHolder holder, int position) {
        Delivered delivered = deliveredList.get(position);
        holder.list_item_quantity.setText(delivered.getItemQuantity());
        holder.list_item_name.setText(delivered.getItemName());

    }

    @Override
    public int getItemCount() {
        return deliveredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView list_item_name, list_item_quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            list_item_name = itemView.findViewById(R.id.list_item_name);
            list_item_quantity = itemView.findViewById(R.id.list_item_quantity);

        }
    }
}
