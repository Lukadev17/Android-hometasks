package com.example.retrofit_cast_api.api

import com.example.retrofit_cast_api.model.CastResult
import retrofit2.Call
import retrofit2.http.GET

interface CastService {
    @GET("/api/characters")
    fun retrieveCharacters(): Call<CastResult>
}