package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {

    Button modoClasico;
    Button muerteSubita;
    Button colores;
    ImageView settings;
    AudioService asIni;
    List<Cancion> playlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        asIni = new AudioService();
        playlist = new ArrayList<>();

        playlist.add(new Cancion(R.raw.acdcbackinblack,false,true));
        playlist.add(new Cancion(R.raw.tetrisoriginal,false,true));

        asIni.start(this,R.raw.tetrisoriginal);
        playlist.get(1).escogida=true;

        modoClasico = (Button)findViewById(R.id.clasico);
        modoClasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inicio.this,MainActivity.class);
                intent.putExtra("MODO",0);
                for(int i = 0; i<playlist.size();i++){
                    intent.putExtra("ruta",playlist.get(i).ruta);
                    intent.putExtra("b1", playlist.get(i).escogida);
                    intent.putExtra("b2", playlist.get(i).disp);
                }
                startActivity(intent);
                asIni.pause();
            }
        });

        muerteSubita = (Button) findViewById(R.id.subita);
        muerteSubita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Inicio.this,MainActivity.class);
                intent2.putExtra("MODO", 1);
                startActivity(intent2);
                asIni.pause();
            }
        });

        settings = (ImageView)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Inicio.this,OpcionesActivity.class);
                startActivity(intent3);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        asIni.pause();
        startActivity(homeIntent);
    }
}
