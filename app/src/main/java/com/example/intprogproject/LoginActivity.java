package com.example.intprogproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialize your UI components
        etEmail = findViewById(R.id.logEmailAddress);
        etPassword = findViewById(R.id.logPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegistration = findViewById(R.id.logRegistration);

        tvRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Registration.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Use .trim() to ignore accidental spaces at the start/end
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // 2. Access the SharedPreferences where Registration saved the data
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedEmail = prefs.getString("saved_email", "");
                String savedPassword = prefs.getString("saved_password", "");

                // 3. Validation Logic
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                // 4. Check if a user has actually registered yet
                else if (savedEmail.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "No account found. Please register.", Toast.LENGTH_SHORT).show();
                }
                // 5. Compare Input vs Saved Data (The actual "Login")
                else if (email.equals(savedEmail) && password.equals(savedPassword)) {
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                    // Navigate to your Home/Main screen
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    // 6. Provide specific feedback for wrong credentials
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}