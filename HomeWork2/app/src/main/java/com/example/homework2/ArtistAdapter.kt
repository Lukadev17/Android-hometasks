package com.example.homework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_artist.view.*
import kotlinx.android.synthetic.main.item_award.view.*

class ArtistAdapter(private val listener: ((Artist) -> Unit)) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = arrayListOf<Artist>()

    fun updateData(newList: ArrayList<Artist>) {
        data.clear()
        data.addAll(newList)

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == NORMAL_TYPE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
            ArtistViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_award, parent, false)
            ArtistAwardViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == NORMAL_TYPE) {
            holder as ArtistViewHolder
            holder.bind(data[position])
        } else {
            holder as ArtistAwardViewHolder
            holder.bind(data[position])
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].awards == null) {
            NORMAL_TYPE
        } else {
            AWARD_TYPE
        }
    }

    inner class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Artist) {
            itemView.firstName.text = item.firstName
            itemView.lastName.text = item.lastName
            itemView.genres.text = item.genres

            itemView.setOnClickListener {
                listener.invoke(item)
            }
        }

    }

    inner class ArtistAwardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Artist) {
            itemView.AfirstName.text = item.firstName
            itemView.AlastName.text = item.lastName
            itemView.Agenres.text = item.genres
            itemView.Aaward.text = item.awards
            itemView.setOnClickListener {
                listener.invoke(item)
            }
        }
    }


        companion object {
            const val AWARD_TYPE = -1
            const val NORMAL_TYPE = 1
        }
    }