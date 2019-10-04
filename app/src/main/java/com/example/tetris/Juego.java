package com.example.tetris;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Juego extends View implements View.OnClickListener {
    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    private TextView puntos;
    private MainActivity MainActivity;

    public Juego(Context context) {
        super(context);
        this.MainActivity = (MainActivity) context;

        botonRotar = MainActivity.getBotonRotar();
        botonDcha = MainActivity.getBotonDcha();
        botonBajar = MainActivity.getBotonBajar();
        botonIzda = MainActivity.getBotonIzda();

        puntos = MainActivity.getPuntos();
        puntos.setText("54 Millones");

        botonRotar.setOnClickListener(this);
        botonDcha.setOnClickListener(this);
        botonIzda.setOnClickListener(this);
        botonBajar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonDcha:
                puntos.setText("1 Millon");
                break;
            case R.id.botonBajar:
                puntos.setText("2 Millones");
                break;
            case R.id.botonIzda:
                puntos.setText("3 Millones");
                break;
            case R.id.botonRotar:
                puntos.setText("4 Millones");
                break;
        }
    }

}

