package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmailLogin.text.toString()
            val senha = edtPasswordLogin.text.toString()
            val usuario = UserService.logIn(email, senha)
            if(email.isNullOrEmpty()){
                edtEmailLogin.setError("Favor preencher campo e-mail")
            } else if (senha.isNullOrEmpty()) {
                edtPasswordLogin.setError("Favor preencher campo senha")

            } else {
                    if(usuario != null){
                        val intent = Intent(this, WelcomeActivity::class.java )
                        intent.putExtra("NOME", usuario.name)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Usuário não encontrado!", Toast.LENGTH_LONG).show()
                    }
            }
        }
    }
}