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


public class ItemStockFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ItemStockFragment() {
        // Required empty public constructor
    }


    public static ItemStockFragment newInstance(String param1, String param2) {
        ItemStockFragment fragment = new ItemStockFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_stock, container, false);
        ImageView stock_details_back;
        TextView productName, donor, quantity, orderDate, dispatchDate, status;

        productName = view.findViewById(R.id.single_item_product_name);
        donor = view.findViewById(R.id.single_item_donor_name);
        quantity = view.findViewById(R.id.single_item_quantity);
        orderDate = view.findViewById(R.id.single_item_order_date);
        dispatchDate = view.findViewById(R.id.single_item_dispatch_date);
        status = view.findViewById(R.id.single_item_status);
        stock_details_back = view.findViewById(R.id.stock_details_back);

        Bundle bundle = getArguments();

//        productName.setText("Product name: "+itemName);
        quantity.setText("Quantity: "+ String.valueOf(bundle.getString("quantity")));
        productName.setText(String.valueOf(bundle.getString("itemName")));

//        Back button
        stock_details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                InStockFragment inStockFragment = new InStockFragment();
                fragmentTransaction.replace(R.id.fragment_container_pages, inStockFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return view;
    }
}