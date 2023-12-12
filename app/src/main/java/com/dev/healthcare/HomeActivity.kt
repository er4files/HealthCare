// HomeActivity.kt
package com.dev.healthcare

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    // Handle click on Home item
                    // (Optional) Add any specific handling if needed
                    true
                }
                R.id.navigation_notification -> {
                    // Handle click on Notification item
                    startActivity(NotifActivity.newIntent(this))
                    true
                }
                R.id.navigation_profile -> {
                    // Handle click on Profile item
                    startActivity(ProfileActivity.newIntent(this))
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
