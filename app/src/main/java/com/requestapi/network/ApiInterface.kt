package com.requestapi.network

import com.requestapi.model.MovieResponse
import com.requestapi.model.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(ApiUrl.DISCOVER_MOVIES)
    fun getDiscoverMovies (
        @Query("api_key") api_key: String ,
        @Query("sort_by") sort_by: String ,
        @Query("page") page: Int
    ) : Call<MovieResponse>

    @GET(ApiUrl.DISCOVER_TV)
    fun getDiscoverTv(
        @Query("api_key") api_key: String,
        @Query("sort_by") sort_by: String,
        @Query("page") page: Int
    ) : Call<TvResponse>

}