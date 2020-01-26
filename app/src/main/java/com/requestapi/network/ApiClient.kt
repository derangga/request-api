package com.requestapi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null

    fun getApiBuilder(): ApiInterface {
        return retrofit()!!.create(ApiInterface::class.java)
    }

    private fun retrofit(): Retrofit? {

        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }

}