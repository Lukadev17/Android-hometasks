package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.register)
        var firstName = findViewById<View>(R.id.firstName) as EditText
        val lastName = findViewById<View>(R.id.lastName) as EditText


        button.setOnClickListener {
            val intent = Intent(this, DataRecyclerActivity::class.java)
            val firstname = firstName.text.toString().trim()
            val lastname = lastName.text.toString().trim()

            val bundle = Bundle()
            bundle.putString("firstName", firstname)
            bundle.putString("lastName", lastname)
            intent.putExtras(bundle)

            startActivity(intent)

        }
    }
}
