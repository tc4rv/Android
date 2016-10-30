package aula_14.v_code.com.br.aula14;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by tcarv on 10/30/2016.
 */
public class CaixaRequest {
    private OkHttpClient client = new OkHttpClient();
    private String rota = "http://192.168.1.14:8080/Caixa/api/v1";
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public String logar(String agencia, String conta, String senha){
        JSONObject json = new JSONObject();
        String nome = "";

        try{
            json.put("agency", agencia);
            json.put("account", conta);
            json.put("password", senha);
            Log.e("Caixa", json.toString());

            RequestBody body = RequestBody.create(JSON, json.toString());
            Request request = new Request.Builder().url(rota+"/login").post(body).build();

            Response response = client.newCall(request).execute();
            Log.e("response", response.body().toString());

            String res = response.body().string();

            JSONObject jsonRes = new JSONObject(res);

            nome = jsonRes.getString("name");

            Log.e("Nome", nome);
        }
        catch(Exception e){
            nome = null;
        }

        return nome;
    }

    public void transferencia(){

    }

    public void extrato(){

    }
}
