package com.gabrielmarrani.comunicacaofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_b.*
import java.util.*


class MainActivity : AppCompatActivity(), ActivityContract {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager:FragmentManager = supportFragmentManager
        manager.beginTransaction().add(R.id.fltContainer, Fragment_a()).commit()
        manager.beginTransaction().add(R.id.fltContainerResult, Fragment_b()).commit()
    }

    override fun setDados(nome: String, idade: Int) {

        var idadeR = Calendar.getInstance().get(Calendar.YEAR) - idade

        if (idadeR >= 0) {
         txtResultado.text = "$nome, sua idade é $idadeR ano(s)"
        } else {
            txtResultado.text = "$nome ainda não nasceu"
        }
    }
}