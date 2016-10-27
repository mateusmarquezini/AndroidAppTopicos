package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.br.apptopicos.util.PontuadorUtil

class QuintoQuestionarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quinto_questionario)

        responderQuintoQuestionario()
    }

    private fun responderQuintoQuestionario(): Unit {
        val radioGroupQuestionario = findViewById(R.id.radioGroupQuestionarioId) as RadioGroup
        val btnRespostaQuestionario = findViewById(R.id.btnResponder) as Button

        btnRespostaQuestionario.setOnClickListener({ view ->
            // pego a opcao selecionada pelo usuário
            val questaoSelecionada = radioGroupQuestionario.checkedRadioButtonId
            if (questaoSelecionada != -1) {
                // encontro o radio button selecionado pelo retorno do id
                val opcaoEscolhida = findViewById(questaoSelecionada) as RadioButton
                val textoOpcao = opcaoEscolhida.text.toString()
                if (textoOpcao.equals("Safe Navigation")) {
                    PontuadorUtil.addPontos()
                }

                navegarTelaResultadoFinal()
            } else {
                Snackbar.make(view, "Por favor, selecione uma alternativa", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                return@setOnClickListener
            }
        })
    }

    private fun navegarTelaResultadoFinal(): Unit {

        val intentResultadoFinal: Any

        if (PontuadorUtil.pontos >= 4) {
            intentResultadoFinal = Intent(this@QuintoQuestionarioActivity, ResultadoPositivoActivity::class.java)
            startActivity(intentResultadoFinal)
            finish()
        } else {
            intentResultadoFinal = Intent(this@QuintoQuestionarioActivity, ResultadoNegativoActivity::class.java)
            startActivity(intentResultadoFinal)
            finish()
        }
    }
}
