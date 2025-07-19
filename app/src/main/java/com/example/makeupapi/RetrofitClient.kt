package com.example.makeupapi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(Singleton::class)
@Module
object RetrofitClient {
@Singleton
@Provides

    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://makeup-api.herokuapp.com/api/v1/")

            .addConverterFactory(GsonConverterFactory.create())
            .build()
}



    val service= retrofit.create(ProductService::class.java)
}