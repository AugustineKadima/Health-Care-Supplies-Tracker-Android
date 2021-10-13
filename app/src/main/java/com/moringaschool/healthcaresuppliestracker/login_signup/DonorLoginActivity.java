package com.moringaschool.healthcaresuppliestracker.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.routing.DonorActivity;

public class DonorLoginActivity extends AppCompatActivity {
    TextView create_account_instead, donor_login3_title;
    Button login_donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);

        create_account_instead = (TextView) findViewById(R.id.create_account_instead_donor);
        donor_login3_title = (TextView) findViewById(R.id.donor_login3_title);

        donor_login3_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorLoginActivity.this, Login.class));
            }
        });
        login_donor = (Button) findViewById(R.id.btn_login_donor);
        login_donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorLoginActivity.this, DonorActivity.class));
            }
        });
        create_account_instead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorLoginActivity.this, DonorSignUp.class));
            }
        });
    }
}