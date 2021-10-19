package com.moringaschool.healthcaresuppliestracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.List;


public class TrackDetailsFragment extends Fragment {

//
//    private static  String item_name = "name1";
//    private static  String item_quantity = "name2";

//    private String itemName, itemQuantity;
    public TrackDetailsFragment() {
        // Required empty public constructor
    }


//    public static TrackDetailsFragment newInstance(Order order) {
//        TrackDetailsFragment fragment = new TrackDetailsFragment();
//        Bundle args = new Bundle();
//        args.putString("item_name", order.getItemName());
//        args.putString("item_quantity", order.getItemQuantity());
//
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
////            itemName = getArguments().getString("item_name");
////            itemQuantity = getArguments().getString("item_quantity");
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track_details, container, false);
        ImageView track_details_back;
        TextView productName, donor, quantity, orderDate, dispatchDate, status, track_details_map;

        orderDate = view.findViewById(R.id.track_details_order_date);
        productName = view.findViewById(R.id.track_details_product_name);
        donor = view.findViewById(R.id.track_details_donor_name);
        quantity = view.findViewById(R.id.track_details_quantity);
        dispatchDate = view.findViewById(R.id.track_details_dispatch_date);
        status = view.findViewById(R.id.track_details_status);
        track_details_map = view.findViewById(R.id.track_details_map);
        track_details_back = view.findViewById(R.id.track_details_back);

        Bundle bundle = getArguments();

//        productName.setText("Product name: "+itemName);
        quantity.setText("Quantity: "+ String.valueOf(bundle.getString("_quantity")));
        productName.setText(String.valueOf(bundle.getString("_item_name")));
        donor.setText("Donor email: "+ String.valueOf(bundle.getString("_donor_email")));
        status.setText("Status: " + String.valueOf(bundle.getString("status")));
        orderDate.setText("Order date: " + bundle.getString("orderDate"));

        track_details_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MapsFragment mapsFragment = new MapsFragment();

//                mapsFragment.getDeviceLocation();


                fragmentTransaction.replace(R.id.fragment_container_pages, mapsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


//        Back track details
        track_details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TrackFragment trackFragment = new TrackFragment();
                fragmentTransaction.replace(R.id.fragment_container_pages, trackFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return view;
    }
}