package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminSystemConfigurationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_system_configuration)

        val etBaseDeliveryFee = findViewById<EditText>(R.id.etBaseDeliveryFee)
        val etServiceCharge = findViewById<EditText>(R.id.etServiceCharge)
        val etGeofencing = findViewById<EditText>(R.id.etGeofencing)
        val btnSaveConfig = findViewById<Button>(R.id.btnSaveConfig)

        btnSaveConfig.setOnClickListener {
            val fee = etBaseDeliveryFee.text.toString()
            val charge = etServiceCharge.text.toString()
            val radius = etGeofencing.text.toString()

            if (fee.isNotEmpty() && charge.isNotEmpty() && radius.isNotEmpty()) {
                Toast.makeText(this, "System Configuration Saved Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all configuration fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
