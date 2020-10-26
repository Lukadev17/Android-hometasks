package com.example.homework1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class DataRecyclerActivity  : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datarecycler)

        val usernameTextView = findViewById<TextView>(R.id.UserNameTextView)
        val UserNameFirstChar = findViewById<TextView>(R.id.UserNameFirstChar)
        val firstNameLength = findViewById<TextView>(R.id.firstNameLength)
        val lastNameLength = findViewById<TextView>(R.id.lastNameLength)
        val bundle = intent.extras

        if (bundle != null) {
            val firstName  = bundle.getString("firstName").toString()
            val lastName = bundle.getString("lastName").toString()

            usernameTextView.text = "Hello $firstName $lastName"


            UserNameFirstChar.text =
                "Your name's first character is  " + firstName.get(0)

            firstNameLength.text = "Your name's lenght is " + firstName.length
            lastNameLength.text = "Your lastname's length is " + lastName.length

        }






    }
}