package aula_14.v_code.com.br.aula14;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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

            RequestBody body = RequestBody.create(JSON, json.toString());
            Request request = new Request.Builder().url(rota+"/login").post(body).build();

            Response response = client.newCall(request).execute();

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

    public double transferencia(String agencia, String conta, double valor){
        JSONObject destino = new JSONObject();
        double quantia = -1;

        try{
            destino.put("agency", agencia);
            destino.put("account", conta);
            destino.put("value", valor);

            RequestBody body = RequestBody.create(JSON, destino.toString());
            Request request = new Request.Builder().url(rota+"/transferencia").post(body).build();

            Response response = client.newCall(request).execute();

            String res = response.body().string();

            JSONObject jsonRes = new JSONObject(res);

            quantia =  jsonRes.getDouble("value");
        }
        catch(Exception e){
            quantia = -1;
        }

        return quantia;
    }

    public ArrayList<String> extrato(){
        ArrayList<String> lista;
        try{
            Request request = new Request.Builder().url(rota+"/extrato").get().build();

            Response response = client.newCall(request).execute();
            //Log.e("response", response.body().toString());

            String res = response.body().string();

            JSONArray jsonRes = new JSONArray(res);

            lista = new ArrayList<String>();

            for(int i = 0; i < jsonRes.length(); i++) {
                String dado = jsonRes.getJSONObject(i).getString("operacao");

                if(dado.equals("0"))
                    dado = "Saque";
                else if(dado.equals("1"))
                    dado = "Extrato";
                else
                    dado = "Transferência";

                lista.add(dado);
                lista.add(jsonRes.getJSONObject(i).getString("data"));
            }
        }
        catch(Exception e){
            lista = null;
        }

        return lista;
    }
}
