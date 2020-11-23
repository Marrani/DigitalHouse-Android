package com.gabrielmarrani.aula35.categoria.repository

class DetalheCategoriaRepository {

private val request = DetalheCategoriaEndpoint.endpoint

    suspend fun obterDetalheCategoria(categoria:String) = request.obterDetalheCategoria(categoria)


}