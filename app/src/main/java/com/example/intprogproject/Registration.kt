package com.example.intprogproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registration : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnCreateAccount: Button
    private lateinit var tvSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        etUsername = findViewById(R.id.regUsername)
        etPhoneNumber = findViewById(R.id.RegPhone)
        etEmail = findViewById(R.id.regEmailAddress)
        etPassword = findViewById(R.id.regPassword)
        etConfirmPassword = findViewById(R.id.regConfirmPass)
        btnCreateAccount = findViewById(R.id.btnCreateAcct)
        tvSignIn = findViewById(R.id.signInText)
    }

    private fun setupClickListeners() {
        btnCreateAccount.setOnClickListener {
            if (validateInputs()) {
                registerUser()
            }
        }

        tvSignIn.setOnClickListener {
            // Navigate to login screen
            val intent = Intent(this@Registration, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateInputs(): Boolean {
        val username = etUsername.text.toString().trim()
        val phoneNumber = etPhoneNumber.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        // Username validation
        if (TextUtils.isEmpty(username)) {
            etUsername.error = "Username is required"
            etUsername.requestFocus()
            return false
        }

        if (username.length < 3) {
            etUsername.error = "Username must be at least 3 characters"
            etUsername.requestFocus()
            return false
        }

        // Phone number validation
        if (TextUtils.isEmpty(phoneNumber)) {
            etPhoneNumber.error = "Phone number is required"
            etPhoneNumber.requestFocus()
            return false
        }

        if (phoneNumber.length < 10) {
            etPhoneNumber.error = "Enter a valid phone number"
            etPhoneNumber.requestFocus()
            return false
        }

        // Email validation
        if (TextUtils.isEmpty(email)) {
            etEmail.error = "Email is required"
            etEmail.requestFocus()
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Enter a valid email address"
            etEmail.requestFocus()
            return false
        }

        // Password validation
        if (TextUtils.isEmpty(password)) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return false
        }

        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return false
        }

        // Confirm password validation
        if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.error = "Please confirm your password"
            etConfirmPassword.requestFocus()
            return false
        }

        if (password != confirmPassword) {
            etConfirmPassword.error = "Passwords do not match"
            etConfirmPassword.requestFocus()
            return false
        }

        return true
    }

    private fun registerUser() {
        val username = etUsername.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("saved_email", email)
        editor.putString("saved_password", password)
        editor.putString("saved_username", username)
        editor.apply()

        val intent = Intent(this@Registration, LoginActivity::class.java)
        startActivity(intent)
        finish()

        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
    }
}
