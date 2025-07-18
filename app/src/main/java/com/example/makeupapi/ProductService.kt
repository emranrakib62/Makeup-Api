package com.example.makeupapi

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("products.json")
    fun getAllProduct(): Call<List<ResponseProduct>>
}
