package com.br.apptopicos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.br.apptopicos.util.PontuadorUtil

class ResultadoPositivoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_positivo)

        var textPontuacao = findViewById(R.id.resultadoFinal) as TextView
        textPontuacao.text = PontuadorUtil.pontos.toString()

        PontuadorUtil.pontos = 0
    }
}
