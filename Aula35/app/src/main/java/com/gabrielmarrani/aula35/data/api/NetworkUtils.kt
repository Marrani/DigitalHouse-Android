package com.gabrielmarrani.aula35.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object {
        private const val BASE_URL = "https://api.chucknorris.io/jokes/"

        fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}