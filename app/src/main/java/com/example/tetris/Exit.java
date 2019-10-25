package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exit extends AppCompatActivity {
    public Ranking ranking = new Ranking();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        Button again = findViewById(R.id.Again);
        Button exit = findViewById(R.id.exit);
        Button registrar = findViewById(R.id.registrar_puntuacion);
        TextView nombre = findViewById(R.id.nombre_jugador);
        final TextView mostrarRanking = findViewById(R.id.mostrarRanking);


        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exit.this, MainActivity.class);
                startActivity(intent);
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ranking.Registrar(view);
                mostrarRanking.setVisibility(view.VISIBLE);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void Registrar(View view){

    }
}