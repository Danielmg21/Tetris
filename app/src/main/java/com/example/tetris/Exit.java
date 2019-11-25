package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exit extends AppCompatActivity {
    private EditText et_nombre;
    //private Button registrar;

    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private boolean registrado;
    private int puntosFinal;
    private int modo;
    private String tipoBBDD;
    private TextView textPuntActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle p = this.getIntent().getExtras();
        puntosFinal = p.getInt("puntuacionFinal");
        modo = p.getInt("Modo");

        BBDD = new AdminSQLiteOpenHelper(this, "RankingJugadores", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        Button again = findViewById(R.id.Again);
        Button registrar = findViewById(R.id.registrar_puntuacion);
        Button rankings = findViewById(R.id.ShowRankings);

        //TextView nombre = findViewById(R.id.nombre_jugador);
        registrado=false;



        et_nombre = (EditText)findViewById(R.id.nombre_jugador);
        textPuntActual= findViewById(R.id.text_puntuacionActual);
        textPuntActual.setText(Integer.toString(puntosFinal));


        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exit.this, Inicio.class);
                startActivity(intent);
            }
        });
        rankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exit.this, Rankings.class);
                startActivity(intent);
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //restablecerEstadiaticas();

                /*
                mostrarRanking1.setVisibility(view.VISIBLE);
                mostrarRanking2.setVisibility(view.VISIBLE);
                mostrarRanking3.setVisibility(view.VISIBLE);
                mostrarRanking4.setVisibility(view.VISIBLE);
                mostrarRanking5.setVisibility(view.VISIBLE);
                mostrarRanking6.setVisibility(view.VISIBLE);
                */

                Registrar(view);
            }
        });


    }
    public void Registrar(View view){
        //abrir la base de datos modo escritura y lectura
        BaseDeDatos = BBDD.getWritableDatabase();
        et_nombre = (EditText)findViewById(R.id.nombre_jugador);
        String nombre = et_nombre.getText().toString();


        if (!nombre.isEmpty() & !registrado){
            //permite almacenar las columnas del registro en pares clave-valor
            ContentValues registro = new ContentValues();
            //Añade los pares
            registro.put("nombre", nombre);
            registro.put("puntuacion", puntosFinal);

            //insertar valores en la tabla ranking
            if(modo==0){
                BaseDeDatos.insert("rankingNormal", null, registro);
            }else{
                BaseDeDatos.insert("rankingHard", null, registro);
            }
            BaseDeDatos.close();

            et_nombre.setText("");
            registrado=true;


        }else{
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Debes rellenar el nombre", Toast.LENGTH_SHORT).show();
            }
            if (registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }

}