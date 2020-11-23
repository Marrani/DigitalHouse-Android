package com.gabrielmarrani.aula35.categoria.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielmarrani.aula35.R
import com.gabrielmarrani.aula35.categoria.repository.CategoriaRepository
import com.gabrielmarrani.aula35.categoria.viewmodel.CategoriaViewModel

class ListaCategoriaFragment : Fragment() {
    lateinit var _viewModel: CategoriaViewModel
    lateinit var _view: View
    private lateinit var _listaAdapter: ListaAdapter
    private var _listaDeCategorias = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_categoria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista = view.findViewById<RecyclerView>(R.id.lista)
        val manager = LinearLayoutManager(view.context)

        val navController: NavController = Navigation.findNavController(view)

         _listaAdapter = ListaAdapter(_listaDeCategorias){
             val bundle = bundleOf("categoria" to it)
             navController.navigate(R.id.action_listaCategoriaFragment_to_detalheFragment, bundle)
         }

        lista.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CategoriaViewModel.CategoriaViewModelFactory(CategoriaRepository())
        ).get(CategoriaViewModel::class.java)

        _viewModel.obterCategoria().observe(viewLifecycleOwner, {
            _listaDeCategorias.addAll(it)
            _listaAdapter.notifyDataSetChanged()

        })


    }

}