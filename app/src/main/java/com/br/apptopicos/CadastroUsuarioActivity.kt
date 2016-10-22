package com.br.apptopicos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastroUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        val botaoIncluirUsuario = findViewById(R.id.btnCadastrar) as Button
        botaoIncluirUsuario.setOnClickListener(View.OnClickListener {
            val senha = findViewById(R.id.cadPassword) as EditText
            val usuario = findViewById(R.id.cadNomeUsuario) as EditText

            val senhaUsuario = senha.text.toString().length
            val nomeUsuario = usuario.text.toString().length

            if (senhaUsuario < 5) {
                Toast.makeText(this@CadastroUsuarioActivity, "A senha deve ter no minimo 5 caracteres", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (nomeUsuario < 5) {
                Toast.makeText(this@CadastroUsuarioActivity, "A campo Usuário deve ter no minimo 5 caracteres", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            Toast.makeText(this@CadastroUsuarioActivity, "Usuário Salvo com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        })
    }
}
