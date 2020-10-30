package com.example.midterm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataReceiverActivity : AppCompatActivity(){

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datareceiver)

        val usernameTextView = findViewById<TextView>(R.id.UserNameTextView)
        val bundle = intent.extras

        if (bundle != null) {
            val firstName  = bundle.getString("firstName").toString()
            val lastName = bundle.getString("lastName").toString()

            usernameTextView.text = "Hello $firstName $lastName"
        }
    }
}