package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void Signup(View view) {

    }

    public void Login(View view) {

        Intent intent_login = new Intent(Signup.this,Login.class);
        startActivity(intent_login);
    }
}