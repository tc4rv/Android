package aula_14.v_code.com.br.aula14;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import okhttp3.internal.Util;

/**
 * Created by tcarv on 10/30/2016.
 */
public class ListaAdapter extends BaseAdapter {
    ArrayList<String> listaFinal;
    Activity activity;

    public ListaAdapter(Activity activity, ArrayList<String> lista){
        listaFinal = lista;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return (listaFinal.size()) / 2;
    }

    @Override
    public Object getItem(int position) {
        return listaFinal.get((2 * position)) + "\n" + listaFinal.get((2 * position) + 1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_lista_item, parent, false);

        TextView operacao = (TextView)view.findViewById(R.id.operacao);
        TextView data = (TextView)view.findViewById(R.id.data);

        operacao.setText(listaFinal.get(2 * position));
        data.setText(listaFinal.get(2 * position + 1));

        return view;
    }
}
