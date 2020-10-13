package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import com.digitalhouse.fakeloginapp.users.UserService.Companion.register
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnLoginSignUpSignUp.setOnClickListener {
            finish()
        }

        checkAgree.setOnCheckedChangeListener{_, isChecked ->
            btnLoginSignUp.isEnabled = isChecked
            
        }

        btnLoginSignUp.setOnClickListener {
            val nome = edtNomeSingUp.text.toString()
            val email = edtEmailSignUp.text.toString()
            val senha = edtPasswordSignUp.text.toString()
            if(nome.isNullOrEmpty()){
                edtNomeSingUp.setError("Favor Preencher o campo nome")
            } else if(email.isNullOrEmpty()){
                edtEmailSignUp.setError("Favor Preencher o campo E-mail")
            } else if(senha.isNullOrEmpty()){
                edtPasswordSignUp.setError("Favor Preencher o campo Password")
            }else {
                try {
                    UserService.register(nome, email, senha)
                    Toast.makeText(this, "Usuário registrado!", Toast.LENGTH_LONG).show()
                    finish()

                } catch (ex: Exception){
                    Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}