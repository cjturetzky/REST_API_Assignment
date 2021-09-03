package com.example.rest_api_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    // Username input id: username_input
    // Password input id: password_input
    // Login button id: login_button
    // Simple logic, check username against database, if found check password against database. Send
    // to MainActivity if check successful. Display error otherwise.

    EditText username_edit;
    EditText password_edit;

    List<String> username_list = new ArrayList<String>(Arrays.asList("cturetzky@csumb.edu"));
    List<String> password_list = new ArrayList<String>(Arrays.asList("testPass"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_edit = (EditText)findViewById(R.id.username_input);
        password_edit = (EditText)findViewById(R.id.password_input);
    }

    public void checkLogin(View view){
        String username = username_edit.getText().toString();
        String password = password_edit.getText().toString();

        int user_id = username_list.indexOf(username);
        if(user_id == -1){ // indexOf returns -1 if username is not found
            // Display error message
            System.out.println("Username " + username + " not found.");
            return;
        }

        String correct_pass = password_list.get(user_id);
        if(correct_pass.equals(password)){ // Get the correct password and check against input pass
            // Launch MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userid", user_id+1);
            System.out.println("Login successful");
            startActivity(intent);
            return;
        }

        System.out.println("Incorrect password");
        return;
    }
}
