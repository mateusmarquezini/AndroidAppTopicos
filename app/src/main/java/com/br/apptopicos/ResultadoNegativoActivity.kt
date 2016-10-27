package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.br.apptopicos.util.PontuadorUtil

class ResultadoNegativoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_negativo)

        val textPontuacao = findViewById(R.id.resultadoFinal) as TextView
        textPontuacao.text = PontuadorUtil.pontos.toString()

        PontuadorUtil.pontos = 0
        navegarTelaPrimeiraQuestao()
    }

    private fun navegarTelaPrimeiraQuestao(): Unit {
        val btnPrimeiraQuestao = findViewById(R.id.btnTentarNovamente) as Button
        btnPrimeiraQuestao.setOnClickListener {
            val intentTentarNovamente = Intent(this@ResultadoNegativoActivity, PrimeiroQuestionarioActivity::class.java)
            startActivity(intentTentarNovamente)
        }
    }
}
