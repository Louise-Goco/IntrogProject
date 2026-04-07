package com.example.intprogproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ensure 'activity_main' matches the name of your XML file
        setContentView(R.layout.activity_main)

        // 1. Initialize the button using the ID from your XML
        val continueButton = findViewById<Button>(R.id.btnContinue)

        // 2. Set up the click listener
        continueButton.setOnClickListener {
            // 3. Create the Intent to move to LoadingActivity instead of LoginActivity directly
            val intent = Intent(this@MainPage, LoadingActivity::class.java)
            startActivity(intent)

            // Optional: call finish() if you don't want the user
            // to come back to this splash/main screen when pressing 'Back'
            // finish()
        }
    }
}
