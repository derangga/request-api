package com.requestapi

import com.requestapi.model.MovieResponse
import com.requestapi.model.TvResponse
import com.requestapi.network.ApiHandler
import com.requestapi.network.ApiInterface
import com.requestapi.network.ApiUrl

class Repository(private val restApi: ApiInterface) {

    fun getMovies(handler: ApiHandler<MovieResponse>){
        restApi.getDiscoverMovies(ApiUrl.TOKEN, "popularity.desc",1)
            .enqueue(handler)
    }

    fun getTv(handler: ApiHandler<TvResponse>){
        restApi.getDiscoverTv(ApiUrl.TOKEN, "popularity.desc", 1)
            .enqueue(handler)
    }
}