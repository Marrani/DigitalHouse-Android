package com.gabrielmarrani.aula35.detalhecategoria.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gabrielmarrani.aula35.categoria.repository.CategoriaRepository
import com.gabrielmarrani.aula35.categoria.repository.DetalheCategoriaRepository
import kotlinx.coroutines.Dispatchers

class DetalheCategoriaViewModel (
    private val repository: DetalheCategoriaRepository

): ViewModel(){

    private lateinit var _categorias: List<String>

    fun obterDetalheCategoria(categoria:String) = liveData(Dispatchers.IO) {
        // Obtem dados da API
        val response = repository.obterDetalheCategoria(categoria)

        emit(response)
    }

    class DetalheCategoriaViewModelFactory(
        private val repository: DetalheCategoriaRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DetalheCategoriaViewModel(repository) as T
        }
    }

}