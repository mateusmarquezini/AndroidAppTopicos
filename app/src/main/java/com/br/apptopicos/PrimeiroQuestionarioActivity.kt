package com.br.apptopicos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
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

        btnRespostaQuestionario.setOnClickListener({
            // pego a opcao selecionada pelo usuário
            val questaoSelecionada = radioGroupQuestionario.checkedRadioButtonId
            if (questaoSelecionada != -1){
                // encontro o radio button selecionado pelo retorno do id
                val opcaoEscolhida = findViewById(questaoSelecionada) as RadioButton
                val textoOpcao = opcaoEscolhida.text.toString()
                if (textoOpcao.equals("->")){
                    PontuadorUtil.addPontos()
                }

                responderSegundoQuestionario()
            } else {
                Toast.makeText(this@PrimeiroQuestionarioActivity, "Por favor, selecione uma alternativa", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        })
    }


    private fun responderSegundoQuestionario(): Unit {
        val intentSegundoQuestionario = Intent(this@PrimeiroQuestionarioActivity, SegundoQuestionarioActivity::class.java)
        startActivity(intentSegundoQuestionario)
    }
}
