package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminRiderManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_rider_management)

        val btnApproveRider = findViewById<Button>(R.id.btnApproveRider)
        val btnMonitorRider = findViewById<Button>(R.id.btnMonitorRider)

        btnApproveRider.setOnClickListener {
            Toast.makeText(this, "Rider Application Approved", Toast.LENGTH_SHORT).show()
        }

        btnMonitorRider.setOnClickListener {
            Toast.makeText(this, "Monitoring Rider Performance & Verification Docs", Toast.LENGTH_SHORT).show()
        }
    }
}
