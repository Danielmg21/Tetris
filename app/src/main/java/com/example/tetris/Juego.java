package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;


public class Juego extends View implements View.OnClickListener {

    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    private int puntos;
    private MainActivity mainActivity;
    private Tablero tablero;
    private ArrayList<Piezas> listaPiezas;
    private Random random = new Random();
    private int nivel=0;

    public Juego(Context context, Tablero tablero) {
        super(context);

        this.mainActivity = (MainActivity) context;
        this.tablero = tablero;

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

    public void run() {

        if (tablero.checkAbajo(tablero.getPieces()) == false) {
            int deletedRows = tablero.clearRows();
            tablero.clearRows();
            listaPiezas.remove(tablero.getPieces());
            listaPiezas.add(new Piezas(random.nextInt(7) + 1));

            if (deletedRows > 0) {
                puntos = (puntos + deletedRows * 30);
            }

            invalidate();
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint pintar = new Paint();

        for (int x = 0; x < tablero.getAlturaTablero(); x++) {
            for (int y = 0; y < tablero.getAnchoTablero(); y++) {

                int color  = tablero.parseaColor(x,y);
                pintar.setColor(color);
                canvas.drawRect(y*30, x*30, y*30+30, x*30+30,pintar);
            }
        }
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

