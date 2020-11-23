package com.gabrielmarrani.aula28.contador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gabrielmarrani.aula28.R
import com.gabrielmarrani.aula28.contador.viewmodel.ContadorViewModel
import com.gabrielmarrani.aula28.contador.viewmodel.ContadorViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ContadorViewModel
    private val _texto by lazy { findViewById<TextView>(R.id.txtTexto)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUi()
    }


    private fun setupViewModel() {
       viewModel = ViewModelProvider(
                this,
                ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)
        viewModel.contador.observe(this, alterarTexto)
    }
    private val alterarTexto = Observer<Int>{
        _texto.text = it.toString()
    }


    private fun setupUi() {
        findViewById<Button>(R.id.btnButton).setOnClickListener {
            viewModel.incrementar()
        }
    }

}