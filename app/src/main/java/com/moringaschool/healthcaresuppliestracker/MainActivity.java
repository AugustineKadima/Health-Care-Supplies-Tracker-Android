package com.moringaschool.healthcaresuppliestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.healthcaresuppliestracker.login_signup.HospitalSignUP;

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
                startActivity(new Intent(MainActivity.this, HospitalSignUP.class));
            }
        });
    }
}