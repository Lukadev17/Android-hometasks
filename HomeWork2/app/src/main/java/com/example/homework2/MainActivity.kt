package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = arrayListOf(
            Artist("Taylor", "Swift", "Pop"),
            Artist("Aubrey Drake", "Graham", "Hip Hop","Artist of the Year"),
            Artist("Ariana", "Grande", "R&B","Best Collaboration"),
            Artist("Ed", "Sheeran", "Pop"),
            Artist("Jennifer", " Lynn Lopez", "R&B","Video of the Year"),
            Artist("Elton", " John", "pop rock"),
            Artist("James Paul", " McCartney","classical","MVP of the Year"),
            Artist("Taylor", "Swift", "Pop","Best Live Performer"),
            Artist("Aubrey Drake", "Graham", "Hip Hop"),
            Artist("Ariana", "Grande", "R&B","Single of the Year"),
            Artist("Ed", "Sheeran", "Pop"),
            Artist("Jennifer", "Lopez", "R&B","Artist of the Year"),
            Artist("Elton Hercules", " John", "pop rock"),
            Artist("James Paul", " McCartney","classical","MVP of the Year")
        )

        val adapter = ArtistAdapter() {
            val intent = Intent(this, ArtistDetailtActivity::class.java)
            val bundle = Bundle()
            if (it.awards == null) {
                bundle.putString("firstName", it.firstName)
                bundle.putString("lastName", it.lastName)
                bundle.putString("genre", it.genres)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                bundle.putString("firstName", it.firstName)
                bundle.putString("lastName", it.lastName)
                bundle.putString("genre", it.genres)
                bundle.putString("awards", it.awards)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            startActivity(intent)
        }

        val dividerDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = adapter
        rvList.addItemDecoration(dividerDecoration)

        adapter.updateData(data)


    }
}