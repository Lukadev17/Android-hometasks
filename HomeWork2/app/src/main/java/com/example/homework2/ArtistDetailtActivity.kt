package com.example.homework2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ArtistDetailtActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artistdetail)

        val firstNameTextView = findViewById<TextView>(R.id.detailFirstName)
        val lastNameTextView = findViewById<TextView>(R.id.detailLastName)
        val genreTextView = findViewById<TextView>(R.id.detailGenre)
        val awardTextView = findViewById<TextView>(R.id.detailAward)
        val bundle = intent.extras

        if (bundle != null) {
            var award = "the artist has no awards"
            val firstName  = bundle.getString("firstName").toString()
            val lastName = bundle.getString("lastName").toString()
            val genre = bundle.getString("genre").toString()
            if (!(bundle.getString("awards") == null)) {
                 award = bundle.getString("awards").toString()
            }

            firstNameTextView.text = "Artist's first name:  $firstName"
            lastNameTextView.text = "Artist's last name:  $lastName"

            genreTextView.text = "genre: $genre"
            awardTextView.text = "awards:  $award"
        }
    }
}