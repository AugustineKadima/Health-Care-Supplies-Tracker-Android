package com.moringaschool.healthcaresuppliestracker.routing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.fragments.InStockFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.NewOrderFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.TrackFragment;
import com.moringaschool.healthcaresuppliestracker.login_signup.Login;
import com.moringaschool.healthcaresuppliestracker.view_model.DeliveredViewModel;
import com.moringaschool.healthcaresuppliestracker.view_model.OrderViewModel;

import java.util.HashMap;

public class ParentActivity extends AppCompatActivity {
    TextView new_order, track, in_stock;
    OrderViewModel orderViewModel;
    DeliveredViewModel deliveredViewModel;
    ProgressBar progressBar;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference deliveredRef = database.getReference("delivered_items");
    DatabaseReference myRef = database.getReference("orders");



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.search_icon);
        MenuItem logout = menu.findItem(R.id.menu_logout);

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

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
               startActivity(new Intent(ParentActivity.this, Login.class));
               return true;
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
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        inStock();


//      Navigate to the order fragment
        new_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new_order.setTextColor(Color.parseColor("#0905CE"));
                track.setTextColor(Color.parseColor("#737272"));
                in_stock.setTextColor(Color.parseColor("#737272"));

                newOrder();
            }
        });

//      Navigate to track orders fragment
        track.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new_order.setTextColor(Color.parseColor("#737272"));
                track.setTextColor(Color.parseColor("#0905CE"));
                in_stock.setTextColor(Color.parseColor("#737272"));
                trackOrder();
            }


        });

//        Navigate to InStock
        in_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new_order.setTextColor(Color.parseColor("#737272"));
                track.setTextColor(Color.parseColor("#737272"));
                in_stock.setTextColor(Color.parseColor("#0905CE"));
                inStock();
            }

        });

       HashMap<String, String> newOrder = new HashMap<>();

//        ViewModel logic
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.getOrder().observe(this, order -> {
            myRef.push().setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(ParentActivity.this, "Order was successful", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ParentActivity.this, "Failed! Please try again", Toast.LENGTH_LONG).show();
                    }
                }
            });
        });

////        View model 2
//        deliveredViewModel = new ViewModelProvider(this).get(DeliveredViewModel.class);
//        deliveredViewModel.getDelivered().observe(this, delivered ->{
//            deliveredRef.push().setValue(delivered).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(ParentActivity.this, "Delivered successfully!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        });

    }

    private void newOrder() {
        progressBar.setVisibility(View.INVISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewOrderFragment newOrderFragment = new NewOrderFragment();
        fragmentTransaction.replace(R.id.fragment_container_pages, newOrderFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void trackOrder() {
        progressBar.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TrackFragment trackFragment = new TrackFragment();
        fragmentTransaction.replace(R.id.fragment_container_pages, trackFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        progressBar.setVisibility(View.INVISIBLE);
    }
    private void inStock() {
        progressBar.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        InStockFragment inStockFragment = new InStockFragment();
        fragmentTransaction.replace(R.id.fragment_container_pages, inStockFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        progressBar.setVisibility(View.INVISIBLE);
    }

}