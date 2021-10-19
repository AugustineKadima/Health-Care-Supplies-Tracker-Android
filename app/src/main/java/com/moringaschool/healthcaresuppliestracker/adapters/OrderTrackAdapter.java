package com.moringaschool.healthcaresuppliestracker.adapters;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.fragments.TrackDetailsFragment;
import com.moringaschool.healthcaresuppliestracker.interfaces.ItemClickListener;
import com.moringaschool.healthcaresuppliestracker.modules.Order;
import com.moringaschool.healthcaresuppliestracker.view_model.DeliveredViewModel;
import com.moringaschool.healthcaresuppliestracker.view_model.OrderViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderTrackAdapter extends RecyclerView.Adapter<OrderTrackAdapter.ViewHolder> {

    Context mContext;
    private List<Order> orders;
    private List<Order> ordersAll;
    ItemClickListener clickListener;
    DeliveredViewModel deliveredViewModel;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference deliveredRef = database.getReference("delivered_items");

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
                Bundle bundle = new Bundle();
                bundle.putString("_quantity", order.getItemQuantity());
                bundle.putString("_donor_email", order.getDonorEmail());
                bundle.putString("_item_name", order.getItemName());
                bundle.putString("status", order.getStatus());
                bundle.putString("orderDate", order.getOrderDate());
                TrackDetailsFragment trackDetailsFragment = new TrackDetailsFragment();
                trackDetailsFragment.setArguments(bundle);

//                clickListener.onItemClick(order);
                ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_pages, trackDetailsFragment).addToBackStack(null).commit();


            }
        });

        holder.btn_confirm_delivery.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                holder.btn_confirm_delivery.setText("Delivered");
                LocalDate localDate = LocalDate.now();
                String deliveryDate = localDate.toString();
                HashMap<String, String> deliveredItems = new HashMap<>();
                deliveredItems.put("itemName", order.getItemName());
                deliveredItems.put("itemQuantity", order.getItemQuantity());
                deliveredItems.put("donorEmail", order.getDonorEmail());
                deliveredItems.put("itemDescription", order.getItemDescription());
                deliveredItems.put("deliveryDate", deliveryDate);
                deliveredItems.put("orderDate", order.getOrderDate());
                order.setStatus("Delivered");
                deliveredItems.put("status", order.getStatus());
                deliveredRef.push().setValue(deliveredItems);
            }
        });

        if(order.getStatus().equals("Delivered")){
            holder.btn_confirm_delivery.setText("Delivered");
            holder.btn_confirm_delivery.setEnabled(false);
        }

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item_name, item_quantity;
        Button btn_confirm_delivery;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.track_item_name);
            item_quantity = itemView.findViewById(R.id.track_item_quantity);

            btn_confirm_delivery = itemView.findViewById(R.id.btn_confirm_delivery);
//            btn_confirm_delivery.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    HashMap<String, String> deliveredItems = new HashMap<>();
//                    deliveredItems.put("itemName", )
//                    deliveredRef.push().setValue("Boy");
//                }
//            });
        }
    }
}
