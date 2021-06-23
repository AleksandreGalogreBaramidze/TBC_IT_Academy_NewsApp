package com.example.newsapplication.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val Instance: RetrofitResponse by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.spaceflightnewsapi.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitResponse::class.java)
    }
}