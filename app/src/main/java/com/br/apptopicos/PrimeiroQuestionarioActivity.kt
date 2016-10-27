package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.br.apptopicos.util.PontuadorUtil

class PrimeiroQuestionarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_questionario)

        responderPrimeiroQuestionario()
    }

    private fun responderPrimeiroQuestionario(): Unit {
        val radioGroupQuestionario = findViewById(R.id.radioGroupQuestionarioId) as RadioGroup
        val btnRespostaQuestionario = findViewById(R.id.btnResponder) as Button

        btnRespostaQuestionario.setOnClickListener({ view ->
            // pego a opcao selecionada pelo usuário
            val questaoSelecionada = radioGroupQuestionario.checkedRadioButtonId
            if (questaoSelecionada != -1) {
                // encontro o radio button selecionado pelo retorno do id
                val opcaoEscolhida = findViewById(questaoSelecionada) as RadioButton
                val textoOpcao = opcaoEscolhida.text.toString()
                if (textoOpcao.equals("->")) {
                    PontuadorUtil.addPontos()
                }

                responderSegundoQuestionario()
            } else {
                Snackbar.make(view, "Por favor, selecione uma alternativa", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                return@setOnClickListener
            }
        })
    }


    private fun responderSegundoQuestionario(): Unit {
        val intentSegundoQuestionario = Intent(this@PrimeiroQuestionarioActivity, SegundoQuestionarioActivity::class.java)
        startActivity(intentSegundoQuestionario)
        finish()
    }
}
