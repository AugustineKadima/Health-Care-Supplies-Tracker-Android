package com.moringaschool.healthcaresuppliestracker.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.view_model.OrderViewModel;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class NewOrderFragment extends Fragment {

    private OrderViewModel orderViewModel;
    EditText item_name, item_quantity, item_description, donor_email;

    public NewOrderFragment() {
        // Required empty public constructor
    }

//
//    // TODO: Rename and change types and number of parameters
//    public static NewOrderFragment newInstance(String param1, String param2) {
//        NewOrderFragment fragment = new NewOrderFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_order, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderViewModel = new ViewModelProvider(requireActivity()).get(OrderViewModel.class);
        Button btn_order = view.findViewById(R.id.btn_confirm_order);
        item_description = view.findViewById(R.id.item_description);
        item_name = view.findViewById(R.id.item_name);
        item_quantity = view.findViewById(R.id.item_quantity);
        donor_email = view.findViewById(R.id.item_donor);
        LocalDate localDate = LocalDate.now();

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String itemName = item_name.getText().toString().trim();
              String itemQuantity = item_quantity.getText().toString().trim();
              String itemDescription = item_description.getText().toString().trim();
              String donorEmail = donor_email.getText().toString().trim();
              String orderDate = localDate.toString();
              orderViewModel.setData(itemName,itemQuantity,itemDescription, donorEmail, orderDate);
            }
        });
    }
}