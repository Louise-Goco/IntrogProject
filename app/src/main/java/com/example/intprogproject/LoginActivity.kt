package com.example.intprogproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegistration: TextView
    private lateinit var tvForgetPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Initialize UI components
        etEmail = findViewById(R.id.logEmailAddress)
        etPassword = findViewById(R.id.logPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegistration = findViewById(R.id.logRegistration)
        tvForgetPassword = findViewById(R.id.logForgetPass)

        tvRegistration.setOnClickListener {
            val intent = Intent(this@LoginActivity, Registration::class.java)
            startActivity(intent)
        }

        tvForgetPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            // 1. Use .trim() to ignore accidental spaces at the start/end
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // 2. Access the SharedPreferences where Registration saved the data
            val prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedEmail = prefs.getString("saved_email", "") ?: ""
            val savedPassword = prefs.getString("saved_password", "") ?: ""

            // 3. Validation Logic
            when {
                email.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
                // 4. Check if a user has actually registered yet
                savedEmail.isEmpty() -> {
                    Toast.makeText(this@LoginActivity, "No account found. Please register.", Toast.LENGTH_SHORT).show()
                }
                // 5. Compare Input vs Saved Data (The actual "Login")
                email == savedEmail && password == savedPassword -> {
                    Toast.makeText(this@LoginActivity, "Login Successful!", Toast.LENGTH_SHORT).show()

                    // Navigate to Home/Dashboard screen
                    val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                // 6. Provide specific feedback for wrong credentials
                else -> {
                    Toast.makeText(this@LoginActivity, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
