package com.br.apptopicos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class PrimeiroQuestionarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeiro_questionario)

        respostaQuestionario()
    }

    fun respostaQuestionario(): Unit {
        val radioGroupQuestionario = findViewById(R.id.radioGroupQuestionarioId) as RadioGroup
        val btnRespostaQuestionario = findViewById(R.id.btnResponder) as Button

        btnRespostaQuestionario.setOnClickListener({
            // pego a opcao selecionada pelo usuário
            val questaoSelecionada = radioGroupQuestionario.checkedRadioButtonId
            // encontro o radio button selecionado pelo retorno do id
            val opcaoEscolhida = findViewById(questaoSelecionada) as RadioButton

            if (opcaoEscolhida.text.toString().equals("A galinha")){
                Toast.makeText(this@PrimeiroQuestionarioActivity, "Você acertou!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@PrimeiroQuestionarioActivity, "Você errou! :(", Toast.LENGTH_SHORT).show()

            }
        })
    }
}
