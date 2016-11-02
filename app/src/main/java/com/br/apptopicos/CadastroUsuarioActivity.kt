package com.br.apptopicos

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

class CadastroUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        val progressBar = findViewById(R.id.progressBarCadUsuario) as ProgressBar
        progressBar.visibility = View.GONE

        val botaoIncluirUsuario = findViewById(R.id.btnCadastrar) as Button
        botaoIncluirUsuario.setOnClickListener(View.OnClickListener { view ->

            progressBar.visibility = View.VISIBLE

            val senha = findViewById(R.id.cadPassword) as EditText
            val usuario = findViewById(R.id.cadNomeUsuario) as EditText

            val senhaUsuario = senha.text.toString()
            val nomeUsuario = usuario.text.toString()

            if (senhaUsuario.length < 5) {
                progressBar.visibility = View.GONE
                Snackbar.make(view, "A senha deve ter no minimo 5 caracteres", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                return@OnClickListener
            }

            if (nomeUsuario.length < 5) {
                progressBar.visibility = View.GONE
                Snackbar.make(view, "A campo Usuário deve ter no minimo 5 caracteres", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                return@OnClickListener
            }

            incluirUsuarioNoServico(nomeUsuario, senhaUsuario, progressBar)

        })
    }

    fun incluirUsuarioNoServico(pNomeUsuario:String, pSenhaUsuario: String, progressBar: ProgressBar): Unit{
        val queue = Volley.newRequestQueue(this)
        val jsonBody = JSONObject("{\"NomeUsuario\":\"$pNomeUsuario\",\"Senha\":\"$pSenhaUsuario\"}")

        val listener = Response.Listener<JSONObject> { response ->

            Log.i("Resposta:", response.toString())

            if(response.toString() == "{\"UsuarioJaExiste\":true}"){
                progressBar.visibility = View.GONE
                Toast.makeText(this@CadastroUsuarioActivity, "Este nome de usuário já está em uso!", Toast.LENGTH_SHORT).show()

            } else if(response.toString() == "{\"InclusaoSucesso\":true}"){
                progressBar.visibility = View.GONE
                Toast.makeText(this@CadastroUsuarioActivity, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()

            } else {
                progressBar.visibility = View.GONE
                Toast.makeText(this@CadastroUsuarioActivity, "Login Inválido! Tente novamente.", Toast.LENGTH_SHORT).show()

            }
        }

        val errorListener = Response.ErrorListener { error ->
            Log.e("Erro:", error.toString())
        }

        val request = JsonObjectRequest(
                Request.Method.POST,
                ENDERECO_INCLUSAO,
                jsonBody,
                listener,
                errorListener)

        queue.add(request)


    }

    companion object {
        private val ENDERECO_INCLUSAO = "http://marquezini.tunim.com.br/api/Usuario/IncluirUsuario"
    }
}
