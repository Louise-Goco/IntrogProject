package com.example.intprogproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ensure 'activity_main' matches the name of your XML file
        setContentView(R.layout.activity_main);

        // 1. Initialize the button using the ID from your XML
        Button continueButton = findViewById(R.id.btnContinue);

        // 2. Set up the click listener
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Create the Intent to move to LoginActivity
                Intent intent = new Intent(MainPage.this, LoginActivity.class);
                startActivity(intent);

                // Optional: call finish() if you don't want the user
                // to come back to this splash/main screen when pressing 'Back'
                // finish();
            }
        });
    }
}