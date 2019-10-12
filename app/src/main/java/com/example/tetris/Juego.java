package com.example.tetris;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Color;

import static java.lang.Integer.parseInt;


public class Juego extends View implements View.OnClickListener {

    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    private TextView puntuacion, nivel;
    private MainActivity mainActivity;
    private Tablero tablero;
    private ArrayList<Pieza> listaPiezas;
    private Random random = new Random();
    private int puntos = 0;
    private int nivelvar = 1;
    private Timer timer = new Timer();
    Pieza p;
    private int timerPeriod = 250;
    int alto = getMeasuredHeight();
    int ancho = getMeasuredWidth();
    int level = 0;

    public Juego(Context context, Tablero tablero) {
        super(context);
        this.mainActivity = (MainActivity) context;
        this.tablero = tablero;

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
        tablero.generarPieza();
        tablero.generarPieza();
        gameLoop();
    }

    public void run1() {
        tablero.moverPiezas(tablero.getPieza(), 'a');
    }

    public void gameLoop() {

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                mainActivity.runOnUiThread(new TimerTask() {

                    @Override
                    public void run() {
                        run1();
                        invalidate();
                    }
                });
            }
        }, 0, timerPeriod);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();
        //Pintamos el tablero back
        Paint pincel = new Paint();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                int color = tablero.parseaColor(x, y);
                pincel.setColor(color);
                canvas.drawRect(x * ancho, y * alto, x * ancho + ancho, y * alto + alto, pincel);
            }
        }

        //Pintamos el tablero front
        Paint pBorde = new Paint();
        pBorde.setStyle(Paint.Style.STROKE);
        pBorde.setColor(Color.BLACK);
        pBorde.setStrokeWidth(2);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                canvas.drawLine((x + 1) * ancho / 10, 0, (x + 1) * ancho / 10, alto, pBorde);
                canvas.drawLine(0, (y + 1) * alto / 20, ancho, (y + 1) * alto / 20, pBorde);
            }
        }

        //Dibujar una pieza
        /*Paint pint = new Paint();
        pint.setColor(Color.YELLOW);
        for(int x=0;x<10;x++){
            for(int y=0;y<20;y++){

                canvas.drawRect((ancho/10)*p.x1,
                        (alto/20)*p.y1,
                        (ancho/10)*p.x2,
                        (alto/20)*p.y2,
                        pint);
                canvas.drawRect((ancho/10)*p.x3,
                        (alto/20)*p.y3,
                        (ancho/10)*p.x4,
                        (alto/20)*p.y4,
                        pint);
            }
        }*/

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botonDcha:
                Toast.makeText(mainActivity, "HOLA PRUEBA", Toast.LENGTH_SHORT).show();
                tablero.moverPiezas(tablero.getPieza(), 'd');
                postInvalidate(0, 0, alto, ancho);
                break;
            case R.id.botonBajar:
                tablero.moverPiezas(tablero.getPieza(), 'a');
                postInvalidate(0, 0, alto, ancho);
                break;
            case R.id.botonIzda:
                tablero.moverPiezas(tablero.getPieza(), 'i');
                postInvalidate(0, 0, alto, ancho);
                break;
            case R.id.botonRotar:
                postInvalidate(0, 0, alto, ancho);
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


