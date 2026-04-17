package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminOrderMonitoringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_order_monitoring)

        findViewById<Button>(R.id.btnFilterDate).setOnClickListener {
            Toast.makeText(this, "Filtering by Date", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnFilterStatus).setOnClickListener {
            Toast.makeText(this, "Filtering by Status", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnFilterSeller).setOnClickListener {
            Toast.makeText(this, "Filtering by Seller", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnFilterRider).setOnClickListener {
            Toast.makeText(this, "Filtering by Rider", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnFilterCustomer).setOnClickListener {
            Toast.makeText(this, "Filtering by Customer", Toast.LENGTH_SHORT).show()
        }
    }
}
