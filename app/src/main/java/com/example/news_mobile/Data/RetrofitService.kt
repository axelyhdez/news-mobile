package com.example.news_mobile.Data

import com.example.news_mobile.Model.NewsModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitMethods {
    @GET("everything?q=paralympics&sortBy=popularity&apiKey=1801b7076c154fdcafa05f0fe932ea07")
    suspend fun getNews():NewsModel
}

object RetrofitServiceFactory{
    fun getNewsRetro():RetrofitMethods{
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitMethods::class.java)
    }
}