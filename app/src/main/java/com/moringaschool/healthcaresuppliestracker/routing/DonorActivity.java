package com.moringaschool.healthcaresuppliestracker.routing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.fragments.AllRequestsFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.DispatchesFragment;
import com.moringaschool.healthcaresuppliestracker.fragments.InStockFragment;

public class DonorActivity extends AppCompatActivity {
    TextView _requests, _dispatches;


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
        setContentView(R.layout.activity_donor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        _requests = (TextView) findViewById(R.id.all_requests_header);
        _dispatches = (TextView) findViewById(R.id.dispatches_header);


        _requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allRequests();
            }
        });

        _dispatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatches();
            }
        });

    }


    private void allRequests() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AllRequestsFragment allRequestsFragment = new AllRequestsFragment();
        fragmentTransaction.replace(R.id.fragment_container_donor_pages, allRequestsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void dispatches() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DispatchesFragment dispatchesFragment = new DispatchesFragment();
        fragmentTransaction.replace(R.id.fragment_container_donor_pages, dispatchesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}