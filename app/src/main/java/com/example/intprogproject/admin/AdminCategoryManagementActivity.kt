package com.example.intprogproject.admin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intprogproject.R

class AdminCategoryManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_category_management)

        val etNewCategory = findViewById<EditText>(R.id.etNewCategory)
        val btnAddCategory = findViewById<Button>(R.id.btnAddCategory)
        val btnUpdateCategory = findViewById<Button>(R.id.btnUpdateCategory)
        val btnDeleteCategory = findViewById<Button>(R.id.btnDeleteCategory)

        btnAddCategory.setOnClickListener {
            val cat = etNewCategory.text.toString()
            if (cat.isNotEmpty()) {
                Toast.makeText(this, "Category '$cat' Added", Toast.LENGTH_SHORT).show()
            }
        }

        btnUpdateCategory.setOnClickListener {
            Toast.makeText(this, "Category Updated", Toast.LENGTH_SHORT).show()
        }

        btnDeleteCategory.setOnClickListener {
            Toast.makeText(this, "Category Deleted", Toast.LENGTH_SHORT).show()
        }
    }
}
