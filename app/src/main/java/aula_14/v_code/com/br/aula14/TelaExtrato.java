package aula_14.v_code.com.br.aula14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class TelaExtrato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_extrato);

        Intent intent = getIntent();
        TextView textViewNomeCliente = (TextView) findViewById(R.id.textView_NomeCliente);
        String message = intent.getStringExtra(MainActivity.NOME_CLIENTE) + ", escolha o intervalo do extrato";

        textViewNomeCliente.setText(message);
    }

    public void consultarExtrato(View view){
        DatePicker datePickerInicio = (DatePicker) findViewById(R.id.datePickerInicio);
        int diaInicio = datePickerInicio.getDayOfMonth();
        int mesInicio = datePickerInicio.getMonth();
        int anoInicio = datePickerInicio.getYear();

        DatePicker datePickerFim = (DatePicker) findViewById(R.id.datePickerFim);
        int diaFim = datePickerFim.getDayOfMonth();
        int mesFim = datePickerFim.getMonth();
        int anoFim = datePickerFim.getYear();

        String teste = "Data início: " + diaInicio + "/" + (mesInicio + 1)+ "/" + anoInicio + "\n" +
                       "Data Término: "+ diaFim + "/" + (mesFim + 1) + "/" + anoFim;

        Toast.makeText(this, teste, Toast.LENGTH_LONG).show();
        //Até aqui, tudo ok.
    }
}
