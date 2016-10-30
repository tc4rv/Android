package aula_14.v_code.com.br.aula14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TelaDeOpcoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_opcoes);

        TextView textViewCliente = (TextView) findViewById(R.id.textView_NomeCliente);
        Intent intent = getIntent();

        String boasVindas = "Olá, " + intent.getStringExtra(MainActivity.NOME_CLIENTE) + ".\nO que deseja fazer?";
        textViewCliente.setText(boasVindas);
    }

    public void extrato(View view){
        Intent intent = getIntent().setClass(this, TelaExtrato.class);
        startActivity(intent);
    }

    public void transferir(View view){
        Intent intent = getIntent().setClass(this, TelaTransferencia.class);
        startActivity(intent);
    }
}
