package com.moringaschool.healthcaresuppliestracker.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.healthcaresuppliestracker.R;

public class HospitalSignUP extends AppCompatActivity {

    TextView donor_sign_up_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_sign_up);

        donor_sign_up_link = (TextView) findViewById(R.id.donor_signup_link);
        donor_sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HospitalSignUP.this, DonorSignUp.class));
            }
        });
    }
}