package com.example.midterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm.model.User

class UsersAdapter(private val listener: ((User) -> Unit)) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = arrayListOf<User>()

    fun updateData(newList: ArrayList<User>) {
        data.clear()
        data.addAll(newList)

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == NORMAL_TYPE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
            UserViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_skills, parent, false)
            SkillsViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == NORMAL_TYPE) {
            holder as UserViewHolder
            holder.bind(data[position])
        } else {
            holder as SkillsViewHolder
//            holder.bind(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].skills == null) {
            NORMAL_TYPE
        } else {
            SKILL_TYPE
        }
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: User) {

            itemView.setOnClickListener {
                listener.invoke(item)
            }
        }
    }

    inner class SkillsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    companion object {
        const val SKILL_TYPE = -1
        const val NORMAL_TYPE = 1
    }
}