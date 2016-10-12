package com.br.apptopicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        final Button botaoIncluirUsuario = (Button) findViewById(R.id.btnCadastrar);
        botaoIncluirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText senha = (EditText) findViewById(R.id.cadPassword);
                final EditText usuario = (EditText) findViewById(R.id.cadNomeUsuario);

                final int senhaUsuario = senha.getText().toString().length();
                final int nomeUsuario = usuario.getText().toString().length();

                if (senhaUsuario < 5){
                    Toast.makeText(CadastroUsuarioActivity.this, "A senha deve ter no minimo 5 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nomeUsuario < 5){
                    Toast.makeText(CadastroUsuarioActivity.this, "A campo Usuário deve ter no minimo 5 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(CadastroUsuarioActivity.this, "Usuário Salvo com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
