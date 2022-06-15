package com.basic.retrofitsample.retrofit.utils

import com.basic.retrofitsample.retrofit.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=in&apiKey=b0928ebdc01f4bc99ac36f0a222dbb0b")
    fun getNewsResponse(): Call<NewsResponse>
}