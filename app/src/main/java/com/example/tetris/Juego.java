package com.example.tetris;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends View implements View.OnClickListener {
    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    private TextView puntos;
    private MainActivity mainActivity;

    public Juego(Context context) {
        super(context);

        this.mainActivity = (MainActivity) context;

        botonRotar = mainActivity.getBotonRotar();
        botonDcha = mainActivity.getBotonDcha();
        botonBajar = mainActivity.getBotonBajar();
        botonIzda = mainActivity.getBotonIzda();
        puntos = mainActivity.getPuntos();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botonDcha:
                Toast.makeText(getContext(), "hola", Toast.LENGTH_LONG).show();
                break;
            case R.id.botonBajar:
                puntos.setText("1");
                break;
            case R.id.botonIzda:
                puntos.setText("1");
                break;
            case R.id.botonRotar:
                puntos.setText("1");
                break;
        }
    }

}

