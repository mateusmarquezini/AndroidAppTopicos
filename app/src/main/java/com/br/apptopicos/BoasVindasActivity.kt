package com.br.apptopicos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class BoasVindasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boas_vindas)

        // navegacao
        navegarParaTelaDePratica()
        navegarParaTelaDeEstudos()

    }

    fun navegarParaTelaDePratica(): Unit {
        val botaoPraticar = findViewById(R.id.btnPraticar) as Button
        botaoPraticar.setOnClickListener {
            val intentPraticar = Intent(this@BoasVindasActivity, PrimeiroQuestionarioActivity::class.java)
            startActivity(intentPraticar)
        }
    }

    fun navegarParaTelaDeEstudos(): Unit {
        val botaoEstudar = findViewById(R.id.btnEstudar) as Button
        botaoEstudar.setOnClickListener {
            val intentEstudar = Intent(this@BoasVindasActivity, EstudarActivity::class.java)
            startActivity(intentEstudar)
        }
    }
}
