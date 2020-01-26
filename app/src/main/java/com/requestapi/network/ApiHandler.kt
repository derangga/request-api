package com.requestapi.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class ApiHandler<T>: Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.isSuccessful && response.body() != null){
            onRequestSuccess(response.body())
        } else {
            onRequestError(response.code(), response.errorBody())
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onNetworkFailure(t)
    }

    abstract fun onRequestSuccess(data: T?)
    abstract fun onRequestError(errorCode: Int, errorBody: ResponseBody?)
    abstract fun onNetworkFailure(throwable: Throwable)

}