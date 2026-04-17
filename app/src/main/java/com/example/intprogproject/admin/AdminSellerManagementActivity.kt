package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminSellerManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_seller_management)

        val btnApproveSeller = findViewById<Button>(R.id.btnApproveSeller)
        val btnSuspendSeller = findViewById<Button>(R.id.btnSuspendSeller)

        btnApproveSeller.setOnClickListener {
            Toast.makeText(this, "Seller Application Approved", Toast.LENGTH_SHORT).show()
        }

        btnSuspendSeller.setOnClickListener {
            Toast.makeText(this, "Seller Account Suspended / Monitored", Toast.LENGTH_SHORT).show()
        }
    }
}
