package com.br.apptopicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button botaoCadastrarUsuario = (Button) findViewById(R.id.btnCadastrarUsuario);
        botaoCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadastrarUsuario = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
                startActivity(intentCadastrarUsuario);
            }
        });
    }
}
