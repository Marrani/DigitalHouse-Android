package com.gabrielmarrani.aula35.categoria.repository

class CategoriaRepository {

private val request = CategoriaEndpoint.endpoint
suspend fun obterCategoria() = request.obterCategoria()


}