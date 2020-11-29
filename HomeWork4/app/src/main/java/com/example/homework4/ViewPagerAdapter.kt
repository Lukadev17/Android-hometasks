package com.example.homework4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter (val Letters: List<CharModel>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)


    }

    override fun getItemCount(): Int {
        return Letters.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentLetter = Letters[position]
        holder.itemView.textView.text = Letters[position].letter.toString()
        holder.itemView.textView2.text = Letters[position].noun1.toString()
        holder.itemView.textView3.text = Letters[position].noun2.toString()
        holder.itemView.textView4.text = Letters[position].noun3.toString()

    }
}