package com.example.midterm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.Toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Midterm Toolbar"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                val intent = Intent(this, ViewActivity::class.java)
                startActivity(intent)
                return true
                }
            }
        return onOptionsItemSelected(item)
        }
}