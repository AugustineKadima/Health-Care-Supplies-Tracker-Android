package com.moringaschool.healthcaresuppliestracker.routing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.fragments.InStockFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.NewOrderFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.TrackFragment;
import com.moringaschool.healthcaresuppliestracker.view_model.OrderViewModel;

import java.util.HashMap;

public class ParentActivity extends AppCompatActivity {
    TextView new_order, track, in_stock;
    OrderViewModel orderViewModel;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("orders");

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new_order =(TextView) findViewById(R.id.new_order_header);
        track = (TextView) findViewById(R.id.track_orders_header);
        in_stock = (TextView) findViewById(R.id.in_stock_header);

//      Navigate to the order fragment
        new_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newOrder();
            }
        });

//      Navigate to track orders fragment
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackOrder();
            }


        });

//        Navigate to InStock
        in_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inStock();
            }

        });

       HashMap<String, String> newOrder = new HashMap<>();

//        ViewModel logic
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.getOrder().observe(this, order -> {
            myRef.push().setValue(order);
        });

    }

    private void newOrder() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewOrderFragment newOrderFragment = new NewOrderFragment();
        fragmentTransaction.add(R.id.fragment_container_pages, newOrderFragment);
        fragmentTransaction.commit();
    }
    private void trackOrder() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TrackFragment trackFragment = new TrackFragment();
        fragmentTransaction.add(R.id.fragment_container_pages, trackFragment);
        fragmentTransaction.commit();

    }
    private void inStock() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        InStockFragment inStockFragment = new InStockFragment();
        fragmentTransaction.add(R.id.fragment_container_pages, inStockFragment);
        fragmentTransaction.commit();
    }

}