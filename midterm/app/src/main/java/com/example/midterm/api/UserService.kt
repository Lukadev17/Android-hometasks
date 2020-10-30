package com.example.midterm.api

import com.example.midterm.model.User
import retrofit2.http.GET
import retrofit2.Call

interface UserService {
    @GET("/v3/0798cb28-d1ba-4c30-9c64-112a372d1d7d")
    fun retrieveUsers(): Call<List<User>>
}