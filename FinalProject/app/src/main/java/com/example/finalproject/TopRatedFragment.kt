package com.example.finalproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.external.ServiceBuilder
import com.example.finalproject.external.TmdbEndpoints
import com.example.finalproject.models.ItemModel
import com.example.finalproject.models.response.PopularMovies
import com.example.finalproject.models.response.TopRatedMovies
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TopRatedFragment : Fragment() {
    val items = ArrayList<ItemModel>()
    private lateinit  var adapter: RecyclerViewAdapter
    private  lateinit var rootview: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_top_rated, container, false)
        adapter = RecyclerViewAdapter()
        val filmTopRatedList = rootview.findViewById<RecyclerView>(R.id.movieView)
        filmTopRatedList.layoutManager = LinearLayoutManager(this.activity)
        filmTopRatedList.adapter = adapter
        loadExamples()

        return filmTopRatedList
    }

    private fun addItem(itemData: ItemModel){
        items.add(itemData)


    }
    //
    private fun loadExamples() {
        val tmdbApi = ServiceBuilder.buildService(TmdbEndpoints::class.java)
        val response = tmdbApi.getMoviesTopRated("e2c5955aea231378ab33a4a249eb10b8")

        response.enqueue(object : Callback<TopRatedMovies> {
            override fun onResponse(call: Call<TopRatedMovies>, response: Response<TopRatedMovies>) {
                val movies = response.body()!!.results
                for (movie in movies) {
                    addItem(
                            ItemModel(
                                    movie.poster_path,
                                    movie.title,
                                    movie.overview,
                                    movie.release_date
                            )
                    )
                }
                adapter.updateData(items)
            }

            override fun onFailure(call: Call<TopRatedMovies>, t: Throwable) {
                Log.d("tmdbApCall", "Error occurred while getting data from tmdbApi")
            }
        })
    }
}
