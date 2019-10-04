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

        Toast.makeText(mainActivity, "Bienvenido al TETRIS", Toast.LENGTH_SHORT).show();

        botonDcha.setOnClickListener(this);
        botonBajar.setOnClickListener(this);
        botonIzda.setOnClickListener(this);
        botonRotar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botonDcha:
                Toast.makeText(mainActivity, "Derecha", Toast.LENGTH_LONG).show();
                break;
            case R.id.botonBajar:
                Toast.makeText(mainActivity, "Bajar", Toast.LENGTH_LONG).show();
                break;
            case R.id.botonIzda:
                Toast.makeText(mainActivity, "Izquierda", Toast.LENGTH_LONG).show();
                break;
            case R.id.botonRotar:
                Toast.makeText(mainActivity, "Rotar", Toast.LENGTH_LONG).show();
                break;
        }
    }

}

