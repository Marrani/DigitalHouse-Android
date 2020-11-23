package com.gabrielmarrani.aula35.categoria.repository

import com.gabrielmarrani.aula35.data.api.NetworkUtils
import retrofit2.http.GET

interface CategoriaEndpoint {
    @GET("categories")
    suspend fun obterCategoria(): List<String>

    companion object {
        val endpoint: CategoriaEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoriaEndpoint::class.java)
        }
    }

}