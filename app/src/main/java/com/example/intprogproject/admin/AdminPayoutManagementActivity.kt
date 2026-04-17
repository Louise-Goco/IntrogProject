package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminPayoutManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_payout_management)

        val btnApprovePayout = findViewById<Button>(R.id.btnApprovePayout)
        val btnConfigSchedule = findViewById<Button>(R.id.btnConfigSchedule)

        btnApprovePayout.setOnClickListener {
            Toast.makeText(this, "Payout Request Approved", Toast.LENGTH_SHORT).show()
        }

        btnConfigSchedule.setOnClickListener {
            Toast.makeText(this, "Payout Schedule Configured", Toast.LENGTH_SHORT).show()
        }
    }
}
