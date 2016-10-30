package aula_14.v_code.com.br.aula14;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaTransferencia extends AppCompatActivity {
    private Activity mainActivity = this;

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

        String agencia = editTextAgencia.getText().toString();
        String conta = editTextConta.getText().toString();
        String valor = editTextValor.getText().toString();

        new TransferenciaAsync().execute(agencia, conta, valor);
    }

    private class TransferenciaAsync extends AsyncTask<String, String, Double> {
        protected Double doInBackground(String... conta){
            CaixaRequest request = new CaixaRequest();

            return request.transferencia(conta[0], conta[1], Double.parseDouble(conta[2]));

        }

        protected void onPostExecute(Double resultado){
            if(resultado < 0){

                Toast.makeText(mainActivity, "Não foi possível efetuar a operação\nVerifique se há saldo suficiente e se os dados da conta de destino estão corretos", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(mainActivity, "Operação realizada com sucesso!", Toast.LENGTH_SHORT).show();
            }

            mainActivity.finish();
        }
    }
}
