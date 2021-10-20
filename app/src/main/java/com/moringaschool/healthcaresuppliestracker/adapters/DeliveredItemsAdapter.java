package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.fragments.InStockFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.ItemStockFragment;
import com.moringaschool.healthcaresuppliestracker.modules.Delivered;

import java.util.ArrayList;
import java.util.List;

public class DeliveredItemsAdapter extends RecyclerView.Adapter<DeliveredItemsAdapter.ViewHolder> {

    List<Delivered> deliveredList;
    List<Delivered> deliveredListAll;
    Context mContext;
    private List<String> userIds;
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("delivered_items");


    public DeliveredItemsAdapter(List<Delivered> deliveredList, Context mContext) {
        this.deliveredList = deliveredList;
        this.mContext = mContext;
        this.deliveredListAll = new ArrayList<>(deliveredList);
        userIds = new ArrayList<>();
    }

    @NonNull
    @Override
    public DeliveredItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.stock_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void setIds(List<String> ids){
        userIds.clear();
        userIds.addAll(ids);
    }

    private void deleteItem(int position) {

        mRef.child(userIds.get(position)).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

            }
        });
    }


    @Override
    public void onBindViewHolder(@NonNull DeliveredItemsAdapter.ViewHolder holder, int position) {
        Delivered delivered = deliveredList.get(position);
        holder.list_item_quantity.setText(delivered.getQuantity().toString());
        holder.list_item_name.setText(delivered.getItemName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemStockFragment itemStockFragment = new ItemStockFragment();

                Bundle bundle = new Bundle();
                bundle.putString("itemName", delivered.getItemName());

                //bundle.putString("deliveryDate", delivered.getDeliveryDate());
                bundle.putString("quantity", delivered.getQuantity().toString());
                bundle.putString("description", delivered.getDescription());
                //bundle.putString("donorEmail", delivered.getDonorEmail());
                bundle.putString("orderDate", delivered.getOrderStatus().toString());

             
                bundle.putString("status", "Delivered");

                itemStockFragment.setArguments(bundle);

                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_pages, itemStockFragment ).addToBackStack(null).commit();

            }
        });

        holder.delete_stock_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.ViewHolder viewHolder = new ViewHolder(holder.itemView);
                deleteItem(position);
                Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return deliveredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView list_item_name, list_item_quantity;
        ImageView delete_stock_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            list_item_name = itemView.findViewById(R.id.list_item_name);
            list_item_quantity = itemView.findViewById(R.id.list_item_quantity);
            delete_stock_item = itemView.findViewById(R.id.list_delete_stock_item);
        }
    }
}
