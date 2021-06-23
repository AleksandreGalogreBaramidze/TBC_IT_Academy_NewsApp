package com.example.newsapplication.retrofit

import com.example.newsapplication.model.SpaceNewsModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitResponse {
    @GET("v3/articles")
    suspend fun getResponse(): Response<List<SpaceNewsModel>>
}