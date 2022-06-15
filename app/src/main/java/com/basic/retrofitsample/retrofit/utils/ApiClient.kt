package com.basic.retrofitsample.retrofit.utils

import com.basic.retrofitsample.config.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
      var myRetrofit: Retrofit? = null

    fun getRetrofit(): Retrofit? {
        if (myRetrofit == null ){
            myRetrofit = Retrofit.Builder()
                .baseUrl(Config().BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return myRetrofit
    }
}