package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void Forget(View view) {
        Intent intent_forget = new Intent(Login.this,Forget.class);
        startActivity(intent_forget);
    }

    public void Login(View view) {

    }

    public void Signup(View view) {
        Intent intent_signup = new Intent(Login.this,Signup.class);
        startActivity(intent_signup);
    }
}