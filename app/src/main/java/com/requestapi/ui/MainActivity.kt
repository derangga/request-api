package com.requestapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.requestapi.R
import com.requestapi.Repository
import com.requestapi.model.MovieResponse
import com.requestapi.model.TvResponse
import com.requestapi.network.ApiClient
import com.requestapi.network.ApiHandler
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var tvAdapter: TvAdapter

    private val repos: Repository by lazy { Repository(ApiClient.getApiBuilder()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        fetchMovies()
    }

    private fun setupRecycler(){
        movieAdapter = MovieAdapter()
        tvAdapter = TvAdapter()
        movieRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = movieAdapter
        }
    }

    private fun fetchMovies(){
        repos.getMovies(object: ApiHandler<MovieResponse>(){
            override fun onRequestSuccess(data: MovieResponse?) {
                movieAdapter.setDataList(data?.results!!)
            }

            override fun onRequestError(errorCode: Int, errorBody: ResponseBody?) {
                setToast("Error $errorCode : ${errorBody.toString()}")
            }

            override fun onNetworkFailure(throwable: Throwable) {
                setToast(throwable.message.toString())
            }
        })
    }

    private fun setToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
