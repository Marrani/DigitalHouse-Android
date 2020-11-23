package com.gabrielmarrani.aula35.detalhecategoria.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.gabrielmarrani.aula35.R
import com.gabrielmarrani.aula35.categoria.repository.CategoriaRepository
import com.gabrielmarrani.aula35.categoria.repository.DetalheCategoriaRepository
import com.gabrielmarrani.aula35.categoria.viewmodel.CategoriaViewModel
import com.gabrielmarrani.aula35.detalhecategoria.model.JokesModel
import com.gabrielmarrani.aula35.detalhecategoria.viewmodel.DetalheCategoriaViewModel
import com.squareup.picasso.Picasso

class DetalheFragment : Fragment() {

    lateinit var _viewModel: DetalheCategoriaViewModel
    lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoria = arguments?.getString("categoria")

        _viewModel = ViewModelProvider(
            this,
            DetalheCategoriaViewModel.DetalheCategoriaViewModelFactory(DetalheCategoriaRepository())
        ).get(DetalheCategoriaViewModel::class.java)

        _viewModel.obterDetalheCategoria(categoria!!).observe(viewLifecycleOwner, {
          exibirResultados(it, view)

        })


    }


    private fun exibirResultados(model: JokesModel, view: View) {

        val imagem = view.findViewById<ImageView>(R.id.imgCategoria)
        val mensagem = view.findViewById<TextView>(R.id.txtMensagem)

        mensagem.text = model.mensagem
        Picasso.get()
            .load(model.imagem)
            .into(imagem)

    }


}