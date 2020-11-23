package com.gabrielmarrani.aula35.categoria.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gabrielmarrani.aula35.categoria.repository.CategoriaRepository
import kotlinx.coroutines.Dispatchers

class CategoriaViewModel (
    private val repository: CategoriaRepository

):ViewModel(){

    fun obterCategoria() = liveData(Dispatchers.IO) {
        // Obtem dados da API
        val response = repository.obterCategoria()

        emit(response)
    }

    class CategoriaViewModelFactory(
        private val repository: CategoriaRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoriaViewModel(repository) as T
        }
    }

}