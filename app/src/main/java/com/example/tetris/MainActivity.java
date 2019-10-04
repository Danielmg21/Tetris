package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    private ImageButton botonDcha, botonBajar, botonIzda, botonRotar;
    TextView puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton botonDcha = (ImageButton) findViewById(R.id.botonDcha);
        ImageButton botonIzda = (ImageButton) findViewById(R.id.botonIzda);
        ImageButton botonBajar = (ImageButton) findViewById(R.id.botonBajar);
        ImageButton botonRotar =(ImageButton) findViewById(R.id.botonRotar);
        TextView puntos = (TextView) findViewById(R.id.puntosText);
        TextView nivel = (TextView) findViewById(R.id.nivelText);

        Juego juego = new Juego(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        juego.setLayoutParams(params);
        RelativeLayout relativeTetris = (RelativeLayout) findViewById(R.id.layoutTablero);
        juego.setBackgroundColor(Color.YELLOW);
        relativeTetris.addView(juego);
    }

    public ImageButton getBotonDcha() { return findViewById(R.id.botonDcha);}
    public ImageButton getBotonBajar() { return findViewById(R.id.botonBajar);}
    public ImageButton getBotonIzda() { return findViewById(R.id.botonIzda);}
    public ImageButton getBotonRotar() { return findViewById(R.id.botonRotar);}
    public TextView getPuntos() { return findViewById(R.id.puntosText); }


}
