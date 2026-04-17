package com.example.intprogproject.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        findViewById<Button>(R.id.btnCustomerMgmt).setOnClickListener {
            startActivity(Intent(this, AdminCustomerManagementActivity::class.java))
        }

        findViewById<Button>(R.id.btnSellerMgmt).setOnClickListener {
            startActivity(Intent(this, AdminSellerManagementActivity::class.java))
        }

        findViewById<Button>(R.id.btnRiderMgmt).setOnClickListener {
            startActivity(Intent(this, AdminRiderManagementActivity::class.java))
        }

        findViewById<Button>(R.id.btnOrderMonitoring).setOnClickListener {
            startActivity(Intent(this, AdminOrderMonitoringActivity::class.java))
        }

        findViewById<Button>(R.id.btnCategoryMgmt).setOnClickListener {
            startActivity(Intent(this, AdminCategoryManagementActivity::class.java))
        }

        findViewById<Button>(R.id.btnPayoutMgmt).setOnClickListener {
            startActivity(Intent(this, AdminPayoutManagementActivity::class.java))
        }

        findViewById<Button>(R.id.btnSystemConfig).setOnClickListener {
            startActivity(Intent(this, AdminSystemConfigurationActivity::class.java))
        }
    }
}
