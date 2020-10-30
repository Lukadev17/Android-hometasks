package com.example.midterm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm.api.UserRetriever
import com.example.midterm.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerActivity: AppCompatActivity() {
    private val userRetriever = UserRetriever()
    private val UsersData = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRetriever.searchUsers( object :Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                println(response.body())
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("MainActivity", t.message.toString())
            }
        })

    }
}