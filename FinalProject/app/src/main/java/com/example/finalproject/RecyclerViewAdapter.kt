package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.models.ItemModel
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.*

class RecyclerViewAdapter() :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val items: ArrayList<ItemModel> = arrayListOf()

    fun updateData(items: ArrayList<ItemModel>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(itemModel: ItemModel) {
            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${itemModel.image}").into(itemView.imageView)
//            itemView.titleTextView.text = itemView.titleTextView.text.toString().replace("{title}", itemModel.title)
//            itemView.overviewTextView.text = itemView.overviewTextView.text.toString().replace("{overview}", itemModel.description)
//            itemView.releaseDateTextView.text = itemView.releaseDateTextView.text.toString().replace("{releaseDate}", itemModel.date)
            itemView.titleTextView.text =  itemModel.title
            itemView.overviewTextView.text = itemModel.description
            itemView.releaseDateTextView.text = itemModel.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie,
            parent,
            false
        )
    )


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(items[position])
}