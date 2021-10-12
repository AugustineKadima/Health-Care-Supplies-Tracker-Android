package com.moringaschool.healthcaresuppliestracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moringaschool.healthcaresuppliestracker.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrackDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrackDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrackDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrackDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrackDetailsFragment newInstance(String param1, String param2) {
        TrackDetailsFragment fragment = new TrackDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_track_details, container, false);

        TextView productName, donor, quantity, orderDate, dispatchDate, status;

        orderDate = view.findViewById(R.id.track_details_order_date);
        productName = view.findViewById(R.id.track_details_product_name);
        donor = view.findViewById(R.id.track_details_donor_name);
        quantity = view.findViewById(R.id.track_details_quantity);
        dispatchDate = view.findViewById(R.id.track_details_dispatch_date);
        status = view.findViewById(R.id.track_details_status);
        return view;
    }
}