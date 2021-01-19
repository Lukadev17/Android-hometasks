package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MoviesActivity: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
//    lateinit var toolbar: Toolbar
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        viewPager = findViewById(R.id.viewPager)
//        toolbar = findViewById(R.id.toolbar)
        tabs = findViewById(R.id.tabs)

//        setSupportActionBar(toolbar)
//        supportActionBar?.title = "Explore Movies"

        adapter = ViewPagerAdapter(this)
        adapter.addFragment(UpcomingFragment())
        adapter.addFragment(TopRatedFragment())
        adapter.addFragment(PopularFragment())
        viewPager.adapter = adapter

        TabLayoutMediator(tabs, viewPager) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> tab.text = "Upcoming"
                1 -> tab.text = "Top Rated"
                2 -> tab.text = "Popular"
            }
            viewPager.setCurrentItem(position, true)
        }.attach()

//        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                viewPager.currentItem = tabs.selectedTabPosition
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MoviesActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MoviesActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

}