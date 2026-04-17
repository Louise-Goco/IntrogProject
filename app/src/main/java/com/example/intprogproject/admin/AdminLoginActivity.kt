package com.example.intprogproject.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        val etAdminEmail = findViewById<EditText>(R.id.etAdminEmail)
        val etAdminPassword = findViewById<EditText>(R.id.etAdminPassword)
        val etMfaCode = findViewById<EditText>(R.id.etMfaCode)
        val btnAdminLogin = findViewById<Button>(R.id.btnAdminLogin)

        btnAdminLogin.setOnClickListener {
            val email = etAdminEmail.text.toString()
            val password = etAdminPassword.text.toString()
            val mfaCode = etMfaCode.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && mfaCode.isNotEmpty()) {
                // TODO: Implement actual MFA and Role-Based authentication logic
                Toast.makeText(this, "Admin Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AdminDashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields for secure login", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
