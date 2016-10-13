package com.br.apptopicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        Button botaoEntrar = (Button) findViewById(R.id.btnEntrar);
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // login mockado apenas para teste
                final EditText nomeUsuario = (EditText) findViewById(R.id.loginNomeUsuario);
                final EditText senhaUsuario = (EditText) findViewById(R.id.loginSenhaUsuario);

                final String nomeDigitado = nomeUsuario.getText().toString();
                final String senhaDigitada = senhaUsuario.getText().toString();

                if (nomeDigitado.length() >= 5 && senhaDigitada.length() >= 5
                        && "admin".equals(nomeDigitado)
                        && "admin".equals(senhaDigitada)) {
                } else {
                    Toast.makeText(LoginActivity.this, "Login inválido, tente novamente!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intentEntrar = new Intent(LoginActivity.this, BoasVindasActivity.class);
                startActivity(intentEntrar);
                finish();
            }
        });
    }
}
