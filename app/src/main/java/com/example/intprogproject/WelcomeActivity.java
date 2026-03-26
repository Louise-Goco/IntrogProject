package com.example.intprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private TextView tvDisplayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_user);

        tvDisplayUser = findViewById(R.id.tvDisplayUser);

        // Get the username passed from LoginActivity
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String userName = prefs.getString("saved_username", "Guest");

        if (userName != null && !userName.isEmpty()) {
            tvDisplayUser.setText("Welcome, " + userName + "!");
        } else {
            tvDisplayUser.setText("Welcome, Guest!");
        }
    }
}