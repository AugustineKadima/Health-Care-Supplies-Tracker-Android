package com.moringaschool.healthcaresuppliestracker.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.healthcaresuppliestracker.R;

public class DonorSignUp extends AppCompatActivity {

    TextView hospital_sign_up_link;
    Button create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_up);

        hospital_sign_up_link = (TextView) findViewById(R.id.hospital_signup_link);
        hospital_sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorSignUp.this, HospitalSignUP.class));
            }
        });

        create_account = (Button) findViewById(R.id.btn_donor_create_account);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorSignUp.this, Login.class));
            }
        });
    }
}