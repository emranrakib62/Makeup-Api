package com.example.makeupapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit= Retrofit.Builder()
        .baseUrl("  https://makeup-api.herokuapp.com/api/v1/")

        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service= retrofit.create(ProductService::class.java)
}