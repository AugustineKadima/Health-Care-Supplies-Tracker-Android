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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DispatchDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DispatchDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DispatchDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DispatchDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DispatchDetailsFragment newInstance(String param1, String param2) {
        DispatchDetailsFragment fragment = new DispatchDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_dispatch_details, container, false);
        TextView productName, donor, quantity, orderDate, dispatchDate, status, dispatch_details_map;
        ImageView dispatch_details_back;

        productName = view.findViewById(R.id.dispatch_details_product_name);
        donor = view.findViewById(R.id.dispatch_details_donor_name);
        quantity = view.findViewById(R.id.dispatch_details_quantity);
        orderDate = view.findViewById(R.id.dispatch_details_order_date);
        dispatchDate = view.findViewById(R.id.dispatch_details_dispatch_date);
        status = view.findViewById(R.id.dispatch_details_status);
        dispatch_details_map = view.findViewById(R.id.dispatch_details_map);
        dispatch_details_back = view.findViewById(R.id.dispatch_details_back);

        dispatch_details_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DispatchDetailsFragment detailsFragment = new DispatchDetailsFragment();

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                MapsFragment mapsFragment= new MapsFragment();
                fragmentTransaction.replace(R.id.fragment_container_donor_pages, mapsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        dispatch_details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DispatchesFragment dispatchesFragment = new DispatchesFragment();
                fragmentTransaction.replace(R.id.fragment_container_donor_pages, dispatchesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}