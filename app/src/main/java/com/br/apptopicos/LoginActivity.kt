package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        navegarTelaCadastro()

        entrarNoApp()
    }

    private fun navegarTelaCadastro() {
        val botaoCadastrarUsuario = findViewById(R.id.btnCadastrarUsuario) as Button
        botaoCadastrarUsuario.setOnClickListener {
            val intentCadastrarUsuario = navegarParaTelaDeCadastro()
            startActivity(intentCadastrarUsuario)
        }
    }

    private fun entrarNoApp() {
        val botaoEntrar = findViewById(R.id.btnEntrar) as Button
        botaoEntrar.setOnClickListener({ view ->

            val nomeUsuario = findViewById(R.id.loginNomeUsuario) as EditText
            val senhaUsuario = findViewById(R.id.loginSenhaUsuario) as EditText

            val nomeDigitado = nomeUsuario.text.toString()
            val senhaDigitada = senhaUsuario.text.toString()

            verificaLoginNoServico(nomeDigitado, senhaDigitada)

        })
    }

    private fun navegarParaTelaInicial(): Unit {
        val intentEntrar = Intent(this@LoginActivity, BoasVindasActivity::class.java)
        startActivity(intentEntrar)
        Toast.makeText(this@LoginActivity, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun navegarParaTelaDeCadastro(): Intent {
        val intentCadastrarUsuario = Intent(this@LoginActivity, CadastroUsuarioActivity::class.java)
        return intentCadastrarUsuario
    }

    private fun verificaLoginNoServico(nomeDigitado: String, senhaDigitada: String) : Unit {
        val queue = Volley.newRequestQueue(this)
        val jsonBody = JSONObject("{\"NomeUsuario\":\"$nomeDigitado\",\"Senha\":\"$senhaDigitada\"}")

        val listener = Response.Listener<JSONObject> { response ->

            Log.i("Resposta:", response.toString())

            if(response.toString() == "{\"Valido\":true}"){
                navegarParaTelaInicial()
            }else {
                Toast.makeText(this@LoginActivity, "Login Inválido! Tente novamente.", Toast.LENGTH_SHORT).show()

            }
        }

        val errorListener = Response.ErrorListener { error ->
            Log.e("Erro:", error.toString())
        }

        val request = JsonObjectRequest(
                Request.Method.POST,
                ENDERECO_LOGIN,
                jsonBody,
                listener,
                errorListener)

        queue.add(request)

    }

    companion object {
        private val ENDERECO_LOGIN = "http://marquezini.tunim.com.br/api/Usuario/Login"
    }
}
