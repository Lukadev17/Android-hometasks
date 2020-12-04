package com.example.midterm2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewActivity: AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        toolbar = findViewById(R.id.Toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Midterm Toolbar"

        val adapter = ViewPagerAdapter()
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = adapter

        TabLayoutMediator(tabLayout, pager) { tab: TabLayout.Tab, position: Int ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}

