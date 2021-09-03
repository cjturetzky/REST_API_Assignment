package com.example.rest_api_assignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    // Username input id: username_input
    // Password input id: password_input
    // Login button id: login_button
    // Simple logic, check username against database, if found check password against database. Send
    // to MainActivity if check successful. Display error otherwise.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
}
