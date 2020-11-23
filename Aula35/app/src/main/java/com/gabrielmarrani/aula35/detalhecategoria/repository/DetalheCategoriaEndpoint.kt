package com.gabrielmarrani.aula35.categoria.repository

import com.gabrielmarrani.aula35.data.api.NetworkUtils
import com.gabrielmarrani.aula35.detalhecategoria.model.JokesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DetalheCategoriaEndpoint {
    @GET("random")
    suspend fun obterDetalheCategoria(@Query("category") category: String): JokesModel

    companion object {
        val endpoint: DetalheCategoriaEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(DetalheCategoriaEndpoint::class.java)
        }
    }

}