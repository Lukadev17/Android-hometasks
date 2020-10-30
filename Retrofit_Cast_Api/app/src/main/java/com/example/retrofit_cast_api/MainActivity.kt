package com.example.retrofit_cast_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit_cast_api.api.CastRetriever
import com.example.retrofit_cast_api.model.CastResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val castRetriever = CastRetriever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        castRetriever.getCharacters( object : Callback<CastResult> {
            override fun onResponse(call: Call<CastResult>, response: Response<CastResult>) {
                println(response.headers())
                println(response.isSuccessful)
                println(response.body())

//                response.body()?.items?.forEach {
//                    repositories.add(ItemRepo.transform(it))
//                }
//
//                println(repositories)
            }

            override fun onFailure(call: Call<CastResult>, t: Throwable) {
                Log.e("MainActivity", t.message.toString())
            }
        })
    }
}