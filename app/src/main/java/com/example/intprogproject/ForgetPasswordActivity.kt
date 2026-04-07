package com.example.intprogproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ForgetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_password)
        
        val tvBackToLogin: TextView = findViewById(R.id.tvBackToLogin)
        tvBackToLogin.setOnClickListener {
            // Since we navigated from LoginActivity, we can just finish this one to go back
            finish()
        }
    }
}
