package com.example.retrofit_cast_api.api

import com.example.retrofit_cast_api.model.CastResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CastRetriever {
    private val service: CastService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(CastService::class.java)
    }

    fun getCharacters( callback: Callback<CastResult>) {
        val call = service.retrieveCharacters()
        call.enqueue(callback)
    }


    companion object {
        const val BASE_URL = "https://www.breakingbadapi.com/"
    }
}