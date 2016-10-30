package aula_14.v_code.com.br.aula14;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String NOME_CLIENTE = "aula_14.com.br.aula_14";
    private AppCompatActivity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view){
        EditText editTextAgencia = (EditText) findViewById(R.id.editText_agencia);
        EditText editTextConta = (EditText) findViewById(R.id.editText_conta);
        EditText editTextSenha = (EditText) findViewById(R.id.editText_password);

        String agencia = editTextAgencia.getText().toString();
        String conta = editTextConta.getText().toString();
        String senha = editTextSenha.getText().toString();

        Log.e("Botão", "passou pelo botão");

        new LogarAsync().execute(agencia, conta, senha);
    }

    private class LogarAsync extends AsyncTask<String, String, String>{
        protected String doInBackground(String... conta){
            CaixaRequest request = new CaixaRequest();

            return request.logar(conta[0], conta[1], conta[2]);

        }

        protected void onPostExecute(String resultado){

            if(resultado != null){
                Intent intent = new Intent(mainActivity, TelaDeOpcoes.class);

                intent.putExtra(NOME_CLIENTE, resultado);
                startActivity(intent);
            }
            else{
                Toast.makeText(mainActivity, "Conta não encontrada. Tente novamente", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
