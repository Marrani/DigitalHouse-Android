package com.gabrielmarrani.aula27.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabrielmarrani.aula27.R
import com.gabrielmarrani.aula27.TodoTarefasFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, TodoTarefasFragment())
        transaction.commit()

    }
}