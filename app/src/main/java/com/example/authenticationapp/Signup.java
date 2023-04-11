package com.example.authenticationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    EditText txt_email,txt_password,txt_cpassword;
    Button signup_btn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();
        init();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txt_email.getText().toString().trim();
                String password = txt_password.getText().toString().trim();
                String cpassword = txt_cpassword.getText().toString().trim();

                if(email.isEmpty())
                {
                    
                    Toast.makeText(Signup.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty())
                {
                    Toast.makeText(Signup.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<6)
                {
                    Toast.makeText(Signup.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(cpassword))
                {
                    Toast.makeText(Signup.this, "Password and confirm password is not match", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent signupIntent = new Intent(getApplicationContext(),Login.class);
                                startActivity(signupIntent);
                                Toast.makeText(Signup.this, "Signup Complete", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
                }


            }
        });
    }

    public void init()
    {

        txt_email= findViewById(R.id.signup_email);
        txt_password = findViewById(R.id.signup_password);
        txt_cpassword = findViewById((R.id.signup_cpassword));
        signup_btn = findViewById(R.id.btn_signup);
    }


    public void Login(View view) {

        Intent intent_login = new Intent(Signup.this,Login.class);
        startActivity(intent_login);
    }
}