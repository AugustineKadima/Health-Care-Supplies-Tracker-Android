package com.moringaschool.healthcaresuppliestracker.login_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.healthcaresuppliestracker.R;

import java.util.HashMap;

public class DonorSignUp extends AppCompatActivity {

    TextView hospital_sign_up_link, login_instead;
    Button create_account;
    EditText donor_name, donor_email, donor_password, donor_location, donor_phone_number;

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("donors");


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
        login_instead = (TextView) findViewById(R.id.login_instead);

        hospital_sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorSignUp.this, HospitalSignUP.class));
            }
        });

        login_instead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonorSignUp.this, DonorLoginActivity.class));
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

                    HashMap<String, String> donorMap = new HashMap<>();
                    donorMap.put("donorName", donorName);
                    donorMap.put("donorEmail", donorEmail);
                    donorMap.put("donorPassword", donorPassword);
                    donorMap.put("donorPhoneNumber", donorPhoneNumber);
                    donorMap.put("donorLocation", donorLocation);

                    myRef.push().setValue(donorMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(DonorSignUp.this, "Account created successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DonorSignUp.this, DonorLoginActivity.class));
                            }else{
                                Toast.makeText(DonorSignUp.this, "Failed! Try again.", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}