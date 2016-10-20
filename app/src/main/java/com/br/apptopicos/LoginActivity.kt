package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val botaoCadastrarUsuario = findViewById(R.id.btnCadastrarUsuario) as Button
        botaoCadastrarUsuario.setOnClickListener {
            val intentCadastrarUsuario = Intent(this@LoginActivity, CadastroUsuarioActivity::class.java)
            startActivity(intentCadastrarUsuario)
        }

        val botaoEntrar = findViewById(R.id.btnEntrar) as Button
        botaoEntrar.setOnClickListener(View.OnClickListener {
            // login mockado apenas para teste
            val nomeUsuario = findViewById(R.id.loginNomeUsuario) as EditText
            val senhaUsuario = findViewById(R.id.loginSenhaUsuario) as EditText

            val nomeDigitado = nomeUsuario.text.toString()
            val senhaDigitada = senhaUsuario.text.toString()

            if (nomeDigitado.length >= 5 && senhaDigitada.length >= 5
                    && "admin" == nomeDigitado
                    && "admin" == senhaDigitada) {
            } else {
                Toast.makeText(this@LoginActivity, "Login inválido, tente novamente!", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val intentEntrar = Intent(this@LoginActivity, BoasVindasActivity::class.java)
            startActivity(intentEntrar)
            finish()
        })
    }
}
