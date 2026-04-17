package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminCustomerManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_customer_management)

        val etSearchCustomer = findViewById<EditText>(R.id.etSearchCustomer)
        val btnSuspendCustomer = findViewById<Button>(R.id.btnSuspendCustomer)
        val btnDeactivateCustomer = findViewById<Button>(R.id.btnDeactivateCustomer)

        btnSuspendCustomer.setOnClickListener {
            Toast.makeText(this, "Customer Suspended", Toast.LENGTH_SHORT).show()
        }

        btnDeactivateCustomer.setOnClickListener {
            Toast.makeText(this, "Customer Deactivated for Policy Violation", Toast.LENGTH_SHORT).show()
        }
    }
}
