package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
            if(tablero.compruebaAbajo(tablero.getPieza())){
                tablero.moverPiezas(tablero.getPieza(),'a');
            }else{
                timer.cancel();
            }
        }
    };

    public void run1() {
        do{
            Tablero tablero = new Tablero();
            int x = 0;
            int y = 0;
            int filaVacio = 0;
            boolean vacio = false;
            while ((y < 20)&&(!vacio)){
                while (x < 10){
                    if (tablero.tab[x][y] == 7){
                        filaVacio ++;
                        timer.schedule(bajar,0,1000);
                    }
                    x++;
                }
                if(filaVacio == 0){
                    tablero.bajarFila(tablero,y);
                    setPuntos(100);
                    puntuacion.setText(getPuntos());
                }
                else if(filaVacio == 10){
                    vacio = true;
                }
                filaVacio = 0;
                y++;
            }
            tablero.borrarPieza();
            tablero.generarPieza();
        }while (tablero.compruebaAbajo(tablero.getPieza()));

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
       // Paint pintar = new Paint();
        int alto = getMeasuredHeight();
        int ancho = getMeasuredWidth();

        int color  = tablero.parseaColor(1,1);
        Paint pBorde = new Paint();
        pBorde.setStyle(Paint.Style.STROKE);
        pBorde.setColor(Color.BLACK);
        pBorde.setStrokeWidth(2);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                canvas.drawLine((x+1)*ancho/10, 0, (x+1)*ancho/10, alto, pBorde);
                /*canvas.drawLine(2*ancho/10, 0, 2*ancho/10, alto, pBorde);
                canvas.drawLine(3*ancho/10, 0, 3*ancho/10, alto, pBorde);
                canvas.drawLine(4*ancho/10, 0, 4*ancho/10, alto, pBorde);
                canvas.drawLine(5*ancho/10, 0, 5*ancho/10, alto, pBorde);
                canvas.drawLine(6*ancho/10, 0, 6*ancho/10, alto, pBorde);
                canvas.drawLine(7*ancho/10, 0, 7*ancho/10, alto, pBorde);
                canvas.drawLine(8*ancho/10, 0, 8*ancho/10, alto, pBorde);
                canvas.drawLine(9*ancho/10, 0, 9*ancho/10, alto, pBorde);
                canvas.drawLine(10*ancho/10, 0, 10*ancho/10, alto, pBorde);*/

                canvas.drawLine(0, (y+1)*alto/20, ancho, (y+1)*alto/20, pBorde);
                /*canvas.drawLine(0, 2*alto/20, ancho, 2*alto/20, pBorde);
        canvas.drawLine(0, 3*alto/20, ancho, 3*alto/20, pBorde);
        canvas.drawLine(0, 4*alto/20, ancho, 4*alto/20, pBorde);
        canvas.drawLine(0, 5*alto/20, ancho, 5*alto/20, pBorde);
        canvas.drawLine(0, 6*alto/20, ancho, 6*alto/20, pBorde);
        canvas.drawLine(0, 7*alto/20, ancho, 7*alto/20, pBorde);
        canvas.drawLine(0, 8*alto/20, ancho, 8*alto/20, pBorde);
        canvas.drawLine(0, 9*alto/20, ancho, 9*alto/20, pBorde);
        canvas.drawLine(0, 10*alto/20, ancho, 10*alto/20, pBorde);*/

                //Marco
                canvas.drawRect(0, 0, ancho, alto, pBorde);
            }
       }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botonDcha:
                char Derecha = 'd';
                tablero.moverPiezas(tablero.getPieza(),Derecha);
                break;
            case R.id.botonBajar:
                char Abajo = 'a';
                tablero.moverPiezas(tablero.getPieza(),Abajo);
                break;
            case R.id.botonIzda:
                char Izquierda = 'i';
                tablero.moverPiezas(tablero.getPieza(),Izquierda);
                break;
            case R.id.botonRotar:
                tablero.getPieza().Girar(tablero.getPieza());
                char Rotar = 'r';
                break;
        }
    }
    public void setPuntos(int puntos){
        this.puntos = this.puntos + puntos;
    }
    public int getPuntos(){
        return this.puntos;
    }
    public int getNivel(){
        return this.nivelvar;
    }

}

