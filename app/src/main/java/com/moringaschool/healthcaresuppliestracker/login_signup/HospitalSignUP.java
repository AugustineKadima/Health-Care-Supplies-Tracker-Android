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

public class HospitalSignUP extends AppCompatActivity {

    TextView donor_sign_up_link, login_instead;
    Button btn_create_account;
    EditText hospital_name, hospital_email, hospital_password, hospital_location, hospital_phone_number;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("hospitals");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_sign_up);

        donor_sign_up_link = (TextView) findViewById(R.id.donor_signup_link);
        hospital_name = (EditText) findViewById(R.id.hospital_name);
        hospital_email = (EditText) findViewById(R.id.hospital_email);
        hospital_password = (EditText) findViewById(R.id.hospital_password);
        hospital_location = (EditText) findViewById(R.id.hospital_location);
        hospital_phone_number = (EditText) findViewById(R.id.hospital_phone_number);
        login_instead = (TextView) findViewById(R.id.login_instead_hospital);
        btn_create_account = (Button) findViewById(R.id.btn_hospital_create_account);

        login_instead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HospitalSignUP.this, Login.class));
            }
        });

        donor_sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HospitalSignUP.this, DonorSignUp.class));
            }
        });


        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hospitalName = hospital_name.getText().toString().trim();
                String hospitalEmail = hospital_email.getText().toString().trim();
                String hospitalPassword = hospital_password.getText().toString().trim();
                String hospitalLocation = hospital_location.getText().toString().trim();
                String hospitalPhoneNumber = hospital_phone_number.getText().toString().trim();

                if(hospitalName.isEmpty() && hospitalEmail.isEmpty() && hospitalLocation.isEmpty() && hospitalPassword.isEmpty() && hospitalPhoneNumber.isEmpty()){
                    Toast.makeText(HospitalSignUP.this, "Fill all spaces and try again", Toast.LENGTH_SHORT).show();
                }

                if(hospitalName.isEmpty()){
                    hospital_name.setError("Hospital name required!");
                    hospital_name.requestFocus();
                }else if(hospitalEmail.isEmpty()){
                    hospital_email.setError("Email required!");
                    hospital_email.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(hospitalEmail).matches()){
                    hospital_email.setError("Use the correct email format!");
                    hospital_email.requestFocus();
                }else if(hospitalPassword.isEmpty()){
                    hospital_password.setError("Password required!");
                    hospital_password.requestFocus();
                }else if(hospitalLocation.isEmpty()){
                    hospital_location.setError("Location required!");
                    hospital_location.requestFocus();
                }else if(hospitalPassword.length() < 6){
                    hospital_password.setError("Password should be a minimum of 6 values");
                    hospital_password.requestFocus();
                }else if(hospitalPhoneNumber.isEmpty()){
                    hospital_phone_number.setError("Phone number required!");
                    hospital_phone_number.requestFocus();
                }else{

                    HashMap<String, String> hospitalMap = new HashMap<>();
                    hospitalMap.put("hospitalName", hospitalName);
                    hospitalMap.put("hospitalEmail", hospitalEmail);
                    hospitalMap.put("hospitalLocation",hospitalLocation);
                    hospitalMap.put("hospitalPhoneNumber", hospitalPhoneNumber);
                    hospitalMap.put("hospitalPassword", hospitalPassword);

                    myRef.push().setValue(hospitalMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(HospitalSignUP.this, "Account created successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(HospitalSignUP.this, Login.class));
                            }else{
                                Toast.makeText(HospitalSignUP.this, "Failed! Try again.", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });

                }

            }
        });
    }
}