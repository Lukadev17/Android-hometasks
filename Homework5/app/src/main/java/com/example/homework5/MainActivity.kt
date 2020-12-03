package com.example.homework5

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var textview : TextView
    lateinit var changeColorbutton : Button
    lateinit var changeActivityButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.Toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Animations Toolbar"

        textview = findViewById(R.id.animatedTextView)
        textview.setOnClickListener{
            changePosition(it)
        }
        changeColorbutton = findViewById(R.id.button)
        changeColorbutton.setOnClickListener{
            changeBackground(textview, "#F44336", "#2196F3")
            changeBackground(changeColorbutton, "#CFE508", "#0697CB")
            changeBackground(changeActivityButton, "#0620CB", "#06CB34")
        }

        changeActivityButton = findViewById(R.id.button3)
        changeActivityButton.setOnClickListener{
            openAnimationActivity()
        }
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

    private fun openAnimationActivity() {
        val intent = Intent(this, AnimationActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    fun changeBackground(view: View, color1: String?, color2: String?) {
        val anim = ValueAnimator()
        anim.setIntValues(Color.parseColor(color1), Color.parseColor(color2))
        anim.setEvaluator(ArgbEvaluator())
        anim.addUpdateListener { valueAnimator -> view.setBackgroundColor((valueAnimator.animatedValue as Int)) }
        anim.duration = 2000
        anim.repeatCount = ValueAnimator.INFINITE
        anim.repeatMode = ValueAnimator.REVERSE
        anim.start()
    }

    fun changePosition(view: View) {
        val range = ValueAnimator.ofFloat(-300f, 300f)
        range.duration = 500L
        range.addUpdateListener { view.translationX = it.animatedValue as Float }
        range.repeatCount = ValueAnimator.INFINITE
        range.repeatMode = ValueAnimator.REVERSE
        range.start()
    }
}