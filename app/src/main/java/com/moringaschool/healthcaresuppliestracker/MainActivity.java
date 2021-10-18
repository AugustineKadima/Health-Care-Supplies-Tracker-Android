package com.moringaschool.healthcaresuppliestracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Filterable;

import com.moringaschool.healthcaresuppliestracker.adapters.InStockAdapter;
import com.moringaschool.healthcaresuppliestracker.adapters.OrderTrackAdapter;
import com.moringaschool.healthcaresuppliestracker.login_signup.HospitalSignUP;
import com.moringaschool.healthcaresuppliestracker.login_signup.Login;
import com.moringaschool.healthcaresuppliestracker.modules.Order;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button get_started;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_started = (Button) findViewById(R.id.btn_get_started);

        get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });

    }


}