package com.moringaschool.healthcaresuppliestracker.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.healthcaresuppliestracker.R;

public class DonorSignUp extends AppCompatActivity {

    TextView hospital_sign_up_link, sign_up_instead;
    Button create_account;
    EditText donor_name, donor_email, donor_password, donor_location, donor_phone_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_up);

        hospital_sign_up_link = (TextView) findViewById(R.id.hospital_signup_link);
        donor_name = (EditText) findViewById(R.id.donor_name);
        donor_email = (EditText) findViewById(R.id.donor_email);
        donor_password = (EditText) findViewById(R.id.donor_password);
        donor_location = (EditText) findViewById(R.id.donor_location);
        donor_phone_number = (EditText) findViewById(R.id.donor_phone_number);
        create_account = (Button) findViewById(R.id.btn_donor_create_account);


        hospital_sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorSignUp.this, HospitalSignUP.class));
            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String donorName = donor_name.getText().toString().trim();
                String donorEmail = donor_email.getText().toString().trim();
                String donorPassword = donor_password.getText().toString().trim();
                String donorLocation = donor_location.getText().toString().trim();
                String donorPhoneNumber = donor_phone_number.getText().toString().trim();

                if(donorName.isEmpty() && donorEmail.isEmpty() && donorPassword.isEmpty() && donorLocation.isEmpty() && donorPhoneNumber.isEmpty()){
                    Toast.makeText(DonorSignUp.this, "Fill all form inputs and try again!", Toast.LENGTH_SHORT).show();
                }

                if(donorName.isEmpty()){
                    donor_name.setError("Name required!");
                    donor_name.requestFocus();
                }else if(donorEmail.isEmpty()){
                    donor_email.setError("Email required!");
                    donor_email.requestFocus();
                }else if(donorPassword.isEmpty()){
                    donor_password.setError("Password required!");
                    donor_password.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(donorEmail).matches()){
                    donor_email.setError("Use the correct email format!");
                    donor_email.requestFocus();
                }else if(donorPassword.length() < 6){
                    donor_password.setError("Password required");
                    donor_password.requestFocus();
                }else if(donorLocation.isEmpty()){
                    donor_location.setError("Location required!");
                    donor_location.requestFocus();
                }else if(donorPhoneNumber.isEmpty()){
                    donor_phone_number.setError("Phone number required!");
                    donor_phone_number.requestFocus();
                }else {
                    startActivity(new Intent(DonorSignUp.this, Login.class));
                }
            }
        });
    }
}