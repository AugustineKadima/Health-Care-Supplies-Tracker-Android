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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.healthcaresuppliestracker.R;
import com.moringaschool.healthcaresuppliestracker.routing.ParentActivity;

public class Login extends AppCompatActivity {

    TextView create_account_instead;
    EditText login_email, login_password;
    Button btn_login;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        create_account_instead = (TextView) findViewById(R.id.create_account_instead_hospital);
        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        mAuth = FirebaseAuth.getInstance();

        create_account_instead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, HospitalSignUP.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(Login.this, "Fill all inputs and try again!", Toast.LENGTH_SHORT).show();
                }

                if(email.isEmpty()){
                    login_email.setError("Email required!");
                    login_email.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    login_email.setError("Use the correct email format");
                    login_email.requestFocus();
                }else if(password.isEmpty()){
                    login_password.setError("Password required!");
                    login_password.requestFocus();
                }else if(password.length() < 6){
                    login_password.setError("Password should have a minimum of 6 values");
                    login_password.requestFocus();
                }else{
                    startActivity(new Intent(Login.this, ParentActivity.class));

//                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                startActivity(new Intent(Login.this, ParentActivity.class));
//                            }else{
//                                Toast.makeText(Login.this, "Failed! Check your credentials and try again.", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
                }
            }
        });
    }
}