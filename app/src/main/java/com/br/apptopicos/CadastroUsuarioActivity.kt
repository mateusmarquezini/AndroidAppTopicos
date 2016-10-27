package com.br.apptopicos

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

class CadastroUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        val botaoIncluirUsuario = findViewById(R.id.btnCadastrar) as Button
        botaoIncluirUsuario.setOnClickListener(View.OnClickListener { view ->
            val senha = findViewById(R.id.cadPassword) as EditText
            val usuario = findViewById(R.id.cadNomeUsuario) as EditText

            val senhaUsuario = senha.text.toString().length
            val nomeUsuario = usuario.text.toString().length

            if (senhaUsuario < 5) {
                Snackbar.make(view, "A senha deve ter no minimo 5 caracteres", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                return@OnClickListener
            }

            if (nomeUsuario < 5) {
                Snackbar.make(view, "A campo Usuário deve ter no minimo 5 caracteres", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                return@OnClickListener
            }

            Snackbar.make(view, "Usuário Salvo com sucesso", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()

        })
    }
}
