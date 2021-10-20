package com.moringaschool.healthcaresuppliestracker.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.healthcaresuppliestracker.Constants;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.adapters.DeliveredItemsAdapter;
import com.moringaschool.healthcaresuppliestracker.interfaces.ItemClickListener;
import com.moringaschool.healthcaresuppliestracker.modules.Delivered;
import com.moringaschool.healthcaresuppliestracker.modules.Order;
import com.moringaschool.healthcaresuppliestracker.network.API;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InStockFragment extends Fragment implements ItemClickListener {

    DeliveredItemsAdapter deliveredItemsAdapter;
    List<Delivered> deliveredList = new ArrayList<>();
    private List<String> userIds;


    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("delivered_items");

    public InStockFragment() {
        // Required empty public constructor
    }


    public static InStockFragment newInstance(String param1, String param2) {
        InStockFragment fragment = new InStockFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_in_stock, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        /*RecyclerView recyclerView = view.findViewById(R.id.recycler_view_in_stock);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        userIds = new ArrayList<>();
        deliveredItemsAdapter = new DeliveredItemsAdapter(deliveredList, view.getContext());
        recyclerView.setAdapter(deliveredItemsAdapter);



        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userIds.clear();
                deliveredList.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Delivered delivered = dataSnapshot.getValue(Delivered.class);
                    deliveredList.add(delivered);
                    userIds.add(dataSnapshot.getKey());
                }
                deliveredItemsAdapter.setIds(userIds);
                deliveredItemsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        Call<List<Delivered>> call = api.getPropertiesInASpecificLocation();

        call.enqueue(new Callback<List<Delivered>>() {
            @Override
            public void onResponse(Call<List<Delivered>> call, Response<List<Delivered>> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Request Successful", Toast.LENGTH_SHORT).show();

                    deliveredList = response.body();
                    Log.d("Response" , deliveredList.get(2).getItemName());
                    RecyclerView recyclerView = view.findViewById(R.id.recycler_view_in_stock);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                    userIds = new ArrayList<>();
                    deliveredItemsAdapter = new DeliveredItemsAdapter(deliveredList, view.getContext());
                    recyclerView.setAdapter(deliveredItemsAdapter);

                } else {
                    //Log.d(TAG, "onResponse: "+ restaurants);
                    //showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Delivered>> call, Throwable t) {
                Toast.makeText(getContext(), "Request Failed", Toast.LENGTH_SHORT).show();
                //hideProgressBar();
                //Log.d(TAG, "onFailure: ", t);
                //showFailureMessage();

            }
        });


    }

    @Override
    public void onItemClick(Order order) {
        Fragment fragment = InStockFragment.newInstance(order.getItemName(), order.getDonorEmail());


        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        ItemStockFragment detailsFragment = new ItemStockFragment();
        fragmentTransaction.replace(R.id.fragment_container_pages, detailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}