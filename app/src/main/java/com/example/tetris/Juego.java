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
    private ArrayList<PiezasAll> listaPiezas;
    private Random random = new Random();
    private int puntos = 0;
    private int nivelvar = 1;
    private Canvas canvas;
    private Pieza[] Piezas;

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
    }

    /*public void run2(){
        tablero.moverPiezas(tablero.getPieza(),'a');
    }*/
    Timer timer = new Timer();
    TimerTask bajar = new TimerTask() {
        @Override
        public void run() {
            if (tablero.compruebaAbajo(tablero.getPieza())) {
                tablero.moverPiezas(tablero.getPieza(), 'a');
            } else {
                timer.cancel();
            }
        }
    };

    public void run1() {
        do {
            Tablero tablero = new Tablero();
            int x = 0;
            int y = 0;
            int filaVacio = 0;
            boolean vacio = false;
            while ((y < 20) && (!vacio)) {
                while (x < 10) {
                    if (tablero.tab[x][y] == 7) {
                        filaVacio++;
                        timer.schedule(bajar, 0, 1000);
                    }
                    x++;
                }
                if (filaVacio == 0) {
                    tablero.bajarFila(tablero, y);
                    setPuntos(100);
                    puntuacion.setText(getPuntos());
                } else if (filaVacio == 10) {
                    vacio = true;
                }
                filaVacio = 0;
                y++;
            }
            tablero.borrarPieza();
            tablero.generarPieza();
            setPincelPiezas(canvas);
        } while (tablero.compruebaAbajo(tablero.getPieza()));

    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        // Paint pintar = new Paint();
        int alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();

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
        Paint pincel = new Paint();
        pincel.setColor(Color.YELLOW);
        for(int x=0;x<10;x++){
            for(int y=0;y<20;y++){
                canvas.drawRect((ancho/10)*4,(alto/20)-(alto/20),(ancho/10)*5,(alto/20),pincel);
                canvas.drawRect((ancho/10)*3,(alto/20),(ancho/10)*6,(alto/20)*2,pincel);
        }
        }


    }

    public void setPincelPiezas(Canvas canvas) {
        int alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();
        Paint pCuadrado = new Paint();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                int val = this.tablero.tab[x][y];
                switch (val) {
                    case 0:
                        pCuadrado.setColor(Color.parseColor("#00FFFF"));
                        break;
                    case 1:
                        pCuadrado.setColor(Color.parseColor("#0000FF"));
                        break;
                    case 2:
                        pCuadrado.setColor(Color.parseColor("#FF0000"));
                        break;
                    case 3:
                        pCuadrado.setColor(Color.parseColor("#FFBF00"));
                        break;
                    case 4:
                        pCuadrado.setColor(Color.parseColor("#00FF00"));
                        break;
                    case 5:
                        pCuadrado.setColor(Color.parseColor("#FFFF00"));
                        break;
                    case 6:
                        pCuadrado.setColor(Color.parseColor("#572364"));
                        break;
                    case 7:
                        pCuadrado.setColor(Color.parseColor("#BEBEBE"));
                        break;
                }
                canvas.drawRect((x * ancho / 10), (y * alto / 20), ((x + 1) * ancho - ancho), ((y + 1) * alto - alto), pCuadrado);
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


