package com.example.tetris;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Juego extends View implements View.OnClickListener {

    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    private TextView puntuacion, nivel;
    private MainActivity mainActivity;
    private Tablero tablero;
    private ArrayList<Pieza> listaPiezas;
    private Random random = new Random();
    private int puntos = 5;
    int cont = 0;
    private int nivelvar = 1;
    private Timer timer = new Timer();
    Pieza p;
    private int timerPeriod = 250;
    private VentanaNext ventana;

    public Juego(Context context, Tablero tablero, VentanaNext ventana) {
        super(context);
        this.mainActivity = (MainActivity) context;
        this.tablero = tablero;
        this.ventana=ventana;
        this.listaPiezas=tablero.listaPiezas;
        botonRotar = mainActivity.getBotonRotar();
        botonDcha = mainActivity.getBotonDcha();
        botonBajar = mainActivity.getBotonBajar();
        botonIzda = mainActivity.getBotonIzda();
        puntuacion = mainActivity.getPuntos();
        nivel = mainActivity.getNivel();

        puntuacion.append(" 0");
        nivel.append(" 1");

        Toast.makeText(mainActivity, "Bienvenido al TETRIS", Toast.LENGTH_SHORT).show();

        botonDcha.setOnClickListener(this);
        botonBajar.setOnClickListener(this);
        botonIzda.setOnClickListener(this);
        botonRotar.setOnClickListener(this);
        gameLoop();
    }

    public void run1() {
        tablero.ponerPieza(tablero.getPieza());
    }

    public void gameLoop() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                mainActivity.runOnUiThread(new TimerTask() {

                    @Override
                    public void run() {
                        if (!tablero.puedeMoverse(tablero.getPieza(), 0, 1) && tablero.getPieza().getAltura() == 0) {
                            mainActivity.finish();
                        } else {
                            run1();
                            if (tablero.puedeMoverse(tablero.getPieza(), 0, 1)) {

                                tablero.moverPiezas(tablero.getPieza(), 'a');
                                timer.cancel();
                                timer = new Timer();
                                gameLoop();
                                cont++;
                            } else {
                                tablero.borrarPieza();
                                tablero.generarPieza();
                                tablero.ponerPieza(tablero.getPieza());
                                ventana.runVentanaNext(listaPiezas.get(1));
                                ventana.invalidate();
                            }
                            invalidate();
                        }
                    }
                });
            }
        }, 1000, timerPeriod);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Pintamos el tablero back
        Paint pincel = new Paint();

        for (int x = 0; x < tablero.getAnchoTablero(); x++) {
            for (int y = 0; y < tablero.getAlturaTablero(); y++) {

                int color = tablero.parseaColor(x, y);
                pincel.setColor(color);
                canvas.drawRect(x * getMeasuredWidth() / 10, y * getMeasuredHeight() / 20, x * getMeasuredWidth() + getMeasuredWidth() / 10,
                        y * getMeasuredHeight() + getMeasuredHeight() / 20, pincel);
            }
        }

        //Pintamos el tablero front
        Paint pBorde = new Paint();
        pBorde.setStyle(Paint.Style.STROKE);
        pBorde.setColor(Color.BLACK);
        pBorde.setStrokeWidth(2);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                canvas.drawLine((x + 1) * getMeasuredWidth() / 10, 0, (x + 1) * getMeasuredWidth() / 10, getMeasuredHeight(), pBorde);
                canvas.drawLine(0, (y + 1) * getMeasuredHeight() / 20, getMeasuredWidth(), (y + 1) * getMeasuredHeight() / 20, pBorde);
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botonDcha:
                tablero.moverPiezas(tablero.getPieza(), 'd');
                invalidate();
                break;
            case R.id.botonBajar:
                tablero.moverPiezas(tablero.getPieza(), 'a');
                invalidate();
                break;
            case R.id.botonIzda:
                tablero.moverPiezas(tablero.getPieza(), 'i');
                invalidate();
                break;
            case R.id.botonRotar:
                Pieza p = tablero.getPieza();
                tablero.borrarPieza();
                p=tablero.alfredoAux(p);
                tablero.ponerPieza(p);
                invalidate();
                break;
        }
    }

    public void setPuntos(int puntos) {
        this.puntos = this.puntos + puntos;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public int getNivel() {
        return this.nivelvar;
    }

}


