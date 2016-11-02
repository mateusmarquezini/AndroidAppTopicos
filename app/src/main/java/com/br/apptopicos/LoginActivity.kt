package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
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

        val progressBar = findViewById(R.id.progressBarLogin) as ProgressBar
        progressBar.visibility = View.GONE

        navegarTelaCadastro()

        entrarNoApp(progressBar)
    }

    private fun navegarTelaCadastro() {
        val botaoCadastrarUsuario = findViewById(R.id.btnCadastrarUsuario) as Button
        botaoCadastrarUsuario.setOnClickListener {
            val intentCadastrarUsuario = navegarParaTelaDeCadastro()
            startActivity(intentCadastrarUsuario)
        }
    }

    private fun entrarNoApp(progressBar: ProgressBar): Unit {
        val botaoEntrar = findViewById(R.id.btnEntrar) as Button
        botaoEntrar.setOnClickListener({ view ->

            progressBar.visibility = View.VISIBLE

            val nomeUsuario = findViewById(R.id.loginNomeUsuario) as EditText
            val senhaUsuario = findViewById(R.id.loginSenhaUsuario) as EditText

            val nomeDigitado = nomeUsuario.text.toString()
            val senhaDigitada = senhaUsuario.text.toString()

            if (validaCamposDigitados(nomeDigitado, senhaDigitada)) {

                verificaLoginNoServico(nomeDigitado, senhaDigitada, progressBar)

            } else {
                progressBar.visibility = View.GONE
                Snackbar.make(view, "Campos obrigatórios não foram preenchidos!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null)
                        .show()
            }
        })
    }

    private fun validaCamposDigitados(nome: String, senha: String): Boolean {
        if (nome.length != 0 && senha.length != 0) return true else return false
    }

    private fun navegarParaTelaInicial(progressBar: ProgressBar): Unit {
        progressBar.visibility = View.GONE
        val intentEntrar = Intent(this@LoginActivity, BoasVindasActivity::class.java)
        startActivity(intentEntrar)
        Toast.makeText(this@LoginActivity, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun navegarParaTelaDeCadastro(): Intent {
        val intentCadastrarUsuario = Intent(this@LoginActivity, CadastroUsuarioActivity::class.java)
        return intentCadastrarUsuario
    }

    private fun verificaLoginNoServico(nomeDigitado: String, senhaDigitada: String, progressBar: ProgressBar): Unit {
        val queue = Volley.newRequestQueue(this)
        val jsonBody = JSONObject("{\"NomeUsuario\":\"$nomeDigitado\",\"Senha\":\"$senhaDigitada\"}")

        val listener = Response.Listener<JSONObject> { response ->

            Log.i("Resposta:", response.toString())

            if (response.toString() == "{\"Valido\":true}") {
                navegarParaTelaInicial(progressBar)
            } else {
                progressBar.visibility = View.GONE
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
