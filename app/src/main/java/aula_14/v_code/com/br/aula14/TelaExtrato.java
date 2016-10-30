package aula_14.v_code.com.br.aula14;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaExtrato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_extrato);

        Intent intent = getIntent();
        TextView textViewNomeCliente = (TextView) findViewById(R.id.textView_NomeCliente);
        String message = intent.getStringExtra(MainActivity.NOME_CLIENTE) + ", veja abaixo o seu extrato";
        textViewNomeCliente.setText(message);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<String> lista = intent.getStringArrayListExtra(TelaDeOpcoes.LISTA_EXTRATO);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);
    }
}
