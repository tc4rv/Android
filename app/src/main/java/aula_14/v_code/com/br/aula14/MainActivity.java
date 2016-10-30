package aula_14.v_code.com.br.aula14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String NOME_CLIENTE = "aula_14.com.br.aula_14";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view){
        EditText editTextAgencia = (EditText) findViewById(R.id.editText_agencia);
        EditText editTextConta = (EditText) findViewById(R.id.editText_conta);
        EditText editTextSenha = (EditText) findViewById(R.id.editText_password);

        int agencia = Integer.parseInt(editTextAgencia.getText().toString());
        int conta = Integer.parseInt(editTextConta.getText().toString());
        int senha = Integer.parseInt(editTextSenha.getText().toString());

        String teste = "Angência: " + agencia +
                       "\nConta: " + conta +
                       "\nSenha: " + senha;

        Toast.makeText(this, teste, Toast.LENGTH_LONG).show();

        /*
            Acredito que aqui vá o método para bater no serviço do gato tom
        */

        Intent intent = new Intent(this, TelaDeOpcoes.class);

        /*
            Aqui, acredito que deva ser colocado O objeto da Conta e pans, mas sou muito burro
            pra ter certeza disso.
        */

        //intent.putExtra(NOME_CLIENTE, cliente.getNome());
        intent.putExtra(NOME_CLIENTE, "Gato Tom");
        startActivity(intent);
    }
}
