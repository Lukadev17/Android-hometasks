package com.example.midterm.api

import com.example.midterm.model.User

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRetriever {
    private val service: UserService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(UserService::class.java)
    }

    fun searchUsers( callback: Callback<List<User>>) {
        val call = service.retrieveUsers()
        call.enqueue(callback)
    }


    companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }
}