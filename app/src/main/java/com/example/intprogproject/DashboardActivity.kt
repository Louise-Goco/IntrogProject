package com.example.intprogproject

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvWelcomeText: TextView = findViewById(R.id.tvWelcomeText)

        // Fetch username from SharedPreferences to make dashboard unique
        val prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val savedUsername = prefs.getString("saved_username", "User") ?: "User"

        tvWelcomeText.text = "Hello, $savedUsername!"
    }
}
