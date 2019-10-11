package com.example.tetris;

import android.content.Context;
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
    private Canvas canvas;
    private Pieza[] Piezas;
    private Timer timer;

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
        pieceActual = new Piece(4);
    }

    public void pintaPieza(Canvas canvas){

}
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        // Paint pintar = new Paint();
        Paint pBorde = new Paint();
        pBorde.setStyle(Paint.Style.STROKE);
        pBorde.setColor(Color.BLACK);
        pBorde.setStrokeWidth(2);
        int alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                canvas.drawLine((x + 1) * ancho / 10, 0, (x + 1) * ancho / 10, alto, pBorde);
                canvas.drawLine(0, (y + 1) * alto / 20, ancho, (y + 1) * alto / 20, pBorde);
            }
        }
        //Dibujar una pieza
        Paint pincel = new Paint();
        pincel.setColor(Color.YELLOW);
        for(int x=0;x<10;x++){
            for(int y=0;y<20;y++){
                canvas.drawRect((ancho/10)*pieceActual.x1,
                        (alto/20)*pieceActual.y1,
                        (ancho/10)*pieceActual.x2,
                        (alto/20)*pieceActual.y2,
                        pincel);
                canvas.drawRect((ancho/10)*pieceActual.x3,(alto/20)*pieceActual.y3,(ancho/10)*pieceActual.x4,(alto/20)*pieceActual.y4,pincel);
            }
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botonDcha:
                char Derecha = 'd';
                tablero.moverPiezas(tablero.getPieza(), Derecha);
                break;
            case R.id.botonBajar:
                char Abajo = 'a';
                tablero.moverPiezas(tablero.getPieza(), Abajo);
                break;
            case R.id.botonIzda:
                char Izquierda = 'i';
                tablero.moverPiezas(tablero.getPieza(), Izquierda);
                break;
            case R.id.botonRotar:
                tablero.getPieza().Girar(tablero.getPieza());
                char Rotar = 'r';
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


