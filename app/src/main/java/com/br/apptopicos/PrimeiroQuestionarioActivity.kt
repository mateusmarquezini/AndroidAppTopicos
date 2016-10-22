package com.br.apptopicos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class PrimeiroQuestionarioActivity : AppCompatActivity() {

    val galinha: String = "A galinha"
    val ovo: String = "O ovo"
    val mensagemVoceAcertou: String = "Você acertou!"
    val mensagemVoceErrou: String = "Você errou! :("

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_questionario)

        responderPrimeiroQuestionario()
    }

    fun responderPrimeiroQuestionario(): Unit {
        val radioGroupQuestionario = findViewById(R.id.radioGroupQuestionarioId) as RadioGroup
        val btnRespostaQuestionario = findViewById(R.id.btnResponder) as Button

        btnRespostaQuestionario.setOnClickListener({
            // pego a opcao selecionada pelo usuário
            val questaoSelecionada = radioGroupQuestionario.checkedRadioButtonId
            // encontro o radio button selecionado pelo retorno do id
            val opcaoEscolhida = findViewById(questaoSelecionada) as RadioButton
            val textoOpcao = opcaoEscolhida.text.toString()

            verificaRespostaPrimeiraQuestao(textoOpcao)
        })
    }

    fun verificaRespostaPrimeiraQuestao(texto: String): Any = when (texto) {
        galinha -> Toast.makeText(this@PrimeiroQuestionarioActivity, mensagemVoceAcertou, Toast.LENGTH_SHORT).show()
        ovo -> Toast.makeText(this@PrimeiroQuestionarioActivity, mensagemVoceErrou, Toast.LENGTH_SHORT).show()
        else -> IllegalArgumentException("")
    }

    fun responderSegundoQuestionario(): Unit {

    }
}
