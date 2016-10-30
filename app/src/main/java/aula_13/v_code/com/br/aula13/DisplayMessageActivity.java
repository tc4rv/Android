package aula_13.v_code.com.br.aula13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = "Olá, " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE) + "\nO que deseja fazer?";

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (RelativeLayout) findViewById(R.id.display_message_activity_layout);
        layout.addView(textView);
    }
}
