package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MoviesActivity: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var toolbar: Toolbar
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        viewPager = findViewById(R.id.viewPager)
        toolbar = findViewById(R.id.toolbar)
        tabs = findViewById(R.id.tabs)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Explore Movies"

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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "You are Signed in", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 -> {
                FirebaseAuth.getInstance().signOut();
                val i =  Intent(this, LoginActivity::class.java);
                startActivity(i);
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
                return true
            }
        }
        return onOptionsItemSelected(item)
    }
}