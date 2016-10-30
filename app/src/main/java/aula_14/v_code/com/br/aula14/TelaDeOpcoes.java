package aula_14.v_code.com.br.aula14;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TelaDeOpcoes extends AppCompatActivity {
    private Activity atividade = this;
    public static final String LISTA_EXTRATO = "aula_14.v_code.com.br.aula14";

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
        new ExtratoAsync().execute();

    }

    public void transferir(View view){
        Intent intent = getIntent().setClass(this, TelaTransferencia.class);
        startActivity(intent);
    }

    private class ExtratoAsync extends AsyncTask<String, String, ArrayList<String>>{

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            CaixaRequest request = new CaixaRequest();

            return request.extrato();
        }

        protected void onPostExecute(ArrayList<String> lista){
            Log.e("Primeiro item da Lista", lista.get(0));

            Intent intent = getIntent().setClass(atividade, TelaExtrato.class);
            intent.putExtra(LISTA_EXTRATO, lista);

            startActivity(intent);
        }
    }
}

