package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    private TextView puntosTextView, nivelTextView;
    private Juego juego;
    private Tablero tablero = new Tablero();
    private Tablero ventana = new Tablero();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonDcha = (ImageButton) findViewById(R.id.botonDcha);
        botonIzda = (ImageButton) findViewById(R.id.botonIzda);
        botonBajar = (ImageButton) findViewById(R.id.botonBajar);
        botonRotar = (ImageButton) findViewById(R.id.botonRotar);
        puntosTextView = (TextView) findViewById(R.id.puntosText);
        nivelTextView = (TextView) findViewById(R.id.nivelText);
        Pieza p = new Pieza(0,0);

        VentanaNext siguientePieza = new VentanaNext(this, ventana, p);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(400,400);
        siguientePieza.setLayoutParams(params1);
        params1.topMargin=50;
        RelativeLayout relativeNext = (RelativeLayout) findViewById(R.id.ventanaSig);
        relativeNext.setBackgroundColor(findViewById(R.id.layoutprincipal).getSolidColor());
        relativeNext.setHorizontalGravity(1);
        relativeNext.addView(siguientePieza);

        Juego juego = new Juego(this, tablero, siguientePieza);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        juego.setLayoutParams(params);
        RelativeLayout relativeTetris = (RelativeLayout) findViewById(R.id.layoutTablero);
        juego.setBackgroundColor(Color.LTGRAY);
        relativeTetris.addView(juego);


    }

    public ImageButton getBotonDcha() {
        return findViewById(R.id.botonDcha);
    }

    public ImageButton getBotonBajar() {
        return findViewById(R.id.botonBajar);
    }

    public ImageButton getBotonIzda() {
        return findViewById(R.id.botonIzda);
    }

    public ImageButton getBotonRotar() {
        return findViewById(R.id.botonRotar);
    }

    public TextView getPuntos() {
        return puntosTextView;
    }

    public TextView getNivel() {
        return nivelTextView;
    }

    public void gameOver(){
        Intent intentGameOver = new Intent(this,Exit.class);
        startActivity(intentGameOver);
    }
}
