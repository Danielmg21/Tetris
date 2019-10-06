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
    TextView puntuacion;
    private int puntos;
    private MainActivity mainActivity;
    private Tablero tablero;
    private ArrayList<PiezasAll> listaPiezas;
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
        puntuacion = mainActivity.getPuntos();

        Toast.makeText(mainActivity, "Bienvenido al TETRIS", Toast.LENGTH_SHORT).show();

        botonDcha.setOnClickListener(this);
        botonBajar.setOnClickListener(this);
        botonIzda.setOnClickListener(this);
        botonRotar.setOnClickListener(this);
        run2();
    }
    public void run2(){
        tablero.moverPiezas(tablero.getPieza(),'a');
    }

    public void run1() {
        do{

            tablero.borrarPieza();
            tablero.generarPieza();
            int x = 0;
            int y = 0;
            int filaVacio = 0;
            boolean vacio = false;
            while ((y != 20)&&(!vacio)){
                while (x !=10){
                    if (tablero.tab[x][y] == 7){
                        filaVacio ++;
                    }
                }
                if(filaVacio == 0){
                    tablero.bajarFila(tablero,y);
                }
                else if(filaVacio == 10){
                    vacio = true;
                }
                filaVacio = 0;
            }
        }while (tablero.compruebaAbajo(tablero.getPieza()));

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint pintar = new Paint();

        for (int x = 0; x < tablero.getAlturaTablero(); x++) {
            for (int y = 0; y < tablero.getAnchoTablero(); y++) {

                int color  = tablero.parseaColor(x,y);
                pintar.setColor(color);
                canvas.drawRect(y, x*90, y*90+90, x*90+90,pintar);
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
                Toast.makeText(mainActivity, "Rotar", Toast.LENGTH_LONG).show();
                char Rotar = 'r';
                break;
        }
    }

}

