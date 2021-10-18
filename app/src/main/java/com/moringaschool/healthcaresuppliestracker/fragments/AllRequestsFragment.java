package com.moringaschool.healthcaresuppliestracker.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.adapters.InStockAdapter;
import com.moringaschool.healthcaresuppliestracker.adapters.OrderRequestsAdapter;
import com.moringaschool.healthcaresuppliestracker.interfaces.ItemClickListener;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.ArrayList;


public class AllRequestsFragment extends Fragment implements ItemClickListener {

    private OrderRequestsAdapter ordersAdapter;
    private ArrayList<Order> orderList = new ArrayList<>();

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("orders");


    public AllRequestsFragment() {
        // Required empty public constructor
    }


    public static AllRequestsFragment newInstance(String param1, String param2) {
        AllRequestsFragment fragment = new AllRequestsFragment();
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

        View view = inflater.inflate(R.layout.fragment_all_requests, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_all_requests);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ordersAdapter = new OrderRequestsAdapter(orderList, view.getContext(), this);
        recyclerView.setAdapter(ordersAdapter);


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Order order = dataSnapshot.getValue(Order.class);
                    orderList.add(order);
                }
                ordersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onItemClick(Order order) {
        Fragment fragment = AllRequestsFragment.newInstance(order.getItemName(), order.getDonorEmail());


        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        ItemRequestFragment detailsFragment = new ItemRequestFragment()      ;
        fragmentTransaction.replace(R.id.fragment_container_donor_pages, detailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_icon);
        SearchView searchview = (SearchView) searchItem.getActionView();

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                InStockAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return false;
    }

    private MenuInflater getMenuInflater() {
        return null;
    }


}