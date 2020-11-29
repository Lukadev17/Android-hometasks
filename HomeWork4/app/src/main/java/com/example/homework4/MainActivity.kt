package com.example.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val LettersList = mutableListOf<CharModel>(
            CharModel('A', "Android", "Adventure" , "Anime"),
            CharModel('B', "Book", "Boat" , "Beer"),
            CharModel('C', "Career", "Challenge" , "Choice"),
            CharModel('D', "Dairy", "Data" , "Date"),
            CharModel('E', "Eagle", "Earth" , "Education"),
            CharModel('F', "Food", "Fuel" , "Football"),
            CharModel('G', "Grass", "Garden" , "GAME"),
            CharModel('H', "Habit", "Half" , "Haircut"),
            CharModel('I', "Ice", "Identity" , "Ideology"),
            CharModel('J', "Jersey", "Jazz" , "Jewel"),
            CharModel('K', "Keyboard", "K'pop" , "Kingdom"),
            CharModel('L', "Lake", "Land" , "Language"),
            CharModel('M', "Map", "Magazine" , "Mail"),
            CharModel('N', "Nationality", "Node" , "Night"),
            CharModel('O', "October", "Opinion" , "Onion"),
            CharModel('P', "Pair", "Peace" , "Peanut"),
            CharModel('Q', "Queen", "Query" , "Question"),
            CharModel('R', "Road", "Room" , "Reaction"),
            CharModel('S', "Saga", "Season" , "Shadow"),
            CharModel('T', "Table", "Tackle" , "Talk"),
            CharModel('U', "Unicorn", "Universe" , "Update"),
            CharModel('V', "Vacation", "Value" , "Vehicle"),
            CharModel('W', "Wood", "Wind" , "Window"),
            CharModel('X', "Xenon", "X-mas" , "Xenium"),
            CharModel('Y', "Yacht", "Young" , "Yard"),
            CharModel('Z', "Zoo", "Zodiac" , "Zone")
        )
        val adapter = ViewPagerAdapter(LettersList)
        viewPager.adapter = adapter

    }
}