package com.example.rest_api_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;

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

    private static List<String> username_list = new ArrayList<String>(Arrays.asList("cturetzky@csumb.edu"));
    private static List<String> password_list = new ArrayList<String>(Arrays.asList("testPass"));

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

        int user_id = checkUsername(username);
        if(user_id == -1){
            username_edit.setError("Invalid username");
            return;
        }
        if(checkPassword(user_id, password)){ // If valid login, launch MainActivity
            Intent intent = createIntent(this, user_id, username);
            startActivity(intent);
        }
        else {
            password_edit.setError("Invalid password");
        }
        return;

    }

    public static Intent createIntent(Context context, int user_id, String username){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("userid", user_id);
        intent.putExtra("username", username);
        return intent;
    }

    public static int checkUsername(String username){
        int user_id = username_list.indexOf(username);
        if(user_id == -1){ // indexOf returns -1 if username is not found
            // Display error message
            return -1;
        }
        return user_id + 1;
    }

    public static boolean checkPassword(int user_id, String password){
        String correct_pass = password_list.get(user_id - 1);
        if(correct_pass.equals(password)){ // Get the correct password and check against input pass
            return true;
        }

        return false;
    }
}
