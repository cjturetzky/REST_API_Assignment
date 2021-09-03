package com.example.rest_api_assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    // Username input id: username_input
    // Password input id: password_input
    // Login button id: login_button
    // Simple logic, check username against database, if found check password against database. Send
    // to MainActivity if check successful. Display error otherwise.

    EditText usernameEdit;
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdit = (EditText)findViewById(R.id.username_input);
        passwordEdit = (EditText)findViewById(R.id.password_input);
    }

    public void checkLogin(View view){
        String username = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        System.out.println("Username: " + username + "\nPassword: " + password);
    }
}
