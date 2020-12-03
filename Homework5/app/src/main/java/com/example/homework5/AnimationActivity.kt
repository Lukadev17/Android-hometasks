package com.example.homework5

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AnimationActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        toolbar = findViewById(R.id.Toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Animations Toolbar"
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
                Toast.makeText(this, "File is Downloading", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3 -> {
                Toast.makeText(this, "File is Uploading", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return onOptionsItemSelected(item)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}