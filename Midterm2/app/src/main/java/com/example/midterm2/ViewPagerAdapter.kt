package com.example.midterm2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val arrayList = listOf<Int>(1, 2, 3)

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ThirdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            firstTab -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager1, parent, false)
                FirstViewHolder(view)
            }
            secondTab -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager2, parent, false)
                SecondViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager3, parent, false)
                ThirdViewHolder(view)
            }
        }
    }


    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            getItemViewType(position) == firstTab -> {
                holder as FirstViewHolder
                holder.itemView.findViewById<TextView>(R.id.textView).text = arrayList[position].toString()
            }
            getItemViewType(position) == secondTab -> {
                holder as SecondViewHolder
                holder.itemView.findViewById<TextView>(R.id.textView).text = arrayList[position].toString()
            }
            else -> {
                holder as ThirdViewHolder
                holder.itemView.findViewById<TextView>(R.id.textView).text = arrayList[position].toString()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            arrayList[position] == 1 -> {
                firstTab
            }
            arrayList[position] == 2 -> {
                secondTab
            }else -> {
                thirdTab
            }
        }
    }
    companion object {
        const val firstTab = 1
        const val secondTab = 2
        const val thirdTab = 3
    }
}