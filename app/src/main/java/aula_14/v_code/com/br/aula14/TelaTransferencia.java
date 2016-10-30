package aula_14.v_code.com.br.aula14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaTransferencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_transferencia);

        Intent intent = getIntent();
        TextView textViewInstrucao = (TextView) findViewById(R.id.textView_NomeCliente);
        String message = intent.getStringExtra(MainActivity.NOME_CLIENTE) + ", preencha os campos.";

        textViewInstrucao.setText(message);
    }

    public void realizarTransferencia(View view){
        EditText editTextAgencia = (EditText) findViewById(R.id.editText_agencia);
        EditText editTextConta = (EditText) findViewById(R.id.editText_conta);
        EditText editTextValor = (EditText) findViewById(R.id.editText_valor);

        int agencia = Integer.parseInt(editTextAgencia.getText().toString());
        int conta = Integer.parseInt(editTextConta.getText().toString());
        double valor = Double.parseDouble(editTextValor.getText().toString());

        String teste = "Agência: " + agencia +
                       "\nConta: " + conta +
                       "\nValor: " + valor;

        Toast.makeText(this, teste, Toast.LENGTH_LONG).show();

        /*
        Intent intent = getIntent().setClass(this, TelaDeOpcoes.class);
        startActivity(intent);
        Toast.makeText(this, "Transferência realizada com sucesso", Toast.LENGTH_LONG).show();
        */
    }
}
