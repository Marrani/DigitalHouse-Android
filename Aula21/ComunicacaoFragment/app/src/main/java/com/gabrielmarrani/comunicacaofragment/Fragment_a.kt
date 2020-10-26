package com.gabrielmarrani.comunicacaofragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*

class Fragment_a : Fragment(){
    lateinit var activity : ActivityContract
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val viewF =  inflater.inflate(R.layout.fragment_a, container, false)

        viewF.btnCalcular.setOnClickListener {
            val nome: String = viewF.edtNome.text.toString()
            val ano = viewF.edtAnoNasc.text.toString()

            activity.setDados(nome, ano.toInt())
            
        }

        return viewF
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as ActivityContract
    }

}