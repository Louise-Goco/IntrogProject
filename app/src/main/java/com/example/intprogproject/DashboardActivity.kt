package com.example.intprogproject

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
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

        val btnGrocery: ImageView = findViewById(R.id.btnGrocery)
        val btnFood: ImageView = findViewById(R.id.btnFood)
        val btnShop: ImageView = findViewById(R.id.btnShop)

        setupHoverAndClick(btnGrocery, listOf("Grocery & Market", "Specialty Grocery", "Alcohol"))
        setupHoverAndClick(btnFood, listOf("Fast Food", "Filipino Food", "American Food"))
        setupHoverAndClick(btnShop, listOf("Gadgets & Electronics", "Hardware", "Lifestyle & Variety"))
    }

    private fun setupHoverAndClick(view: View, items: List<String>) {
        view.setOnClickListener {
            showPopup(it, items)
        }
        view.setOnHoverListener { v, event ->
            if (event.action == MotionEvent.ACTION_HOVER_ENTER) {
                showPopup(v, items)
            }
            false
        }
    }

    private fun showPopup(view: View, items: List<String>) {
        val popup = PopupMenu(this, view)
        items.forEachIndexed { index, item ->
            popup.menu.add(0, index, 0, item)
        }
        popup.show()
    }
}
