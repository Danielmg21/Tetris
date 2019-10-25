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
    private Button registrar;
    private TextView mostrarRanking;
    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BBDD = new AdminSQLiteOpenHelper(this, "RankingJugadores", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        Button again = findViewById(R.id.Again);
        Button exit = findViewById(R.id.exit);
        registrar = findViewById(R.id.registrar_puntuacion);
        TextView nombre = findViewById(R.id.nombre_jugador);
        mostrarRanking = findViewById(R.id.mostrarRanking);

        et_nombre = (EditText)findViewById(R.id.nombre_jugador);

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
                Registrar(view);
                mostrarRanking.setVisibility(view.VISIBLE);
                mostrarTop5(view);
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
        //abrir la base de datos modo escritura y lectura
        BaseDeDatos = BBDD.getWritableDatabase();
        et_nombre = (EditText)findViewById(R.id.nombre_jugador);
        String nombre = et_nombre.getText().toString();

        if ( !nombre.isEmpty()){
            ContentValues registro = new ContentValues();
            //guardar en la base de datos los valores
            registro.put("nombre", nombre);
            //registro.put("puntuacion" score);

            //insertar valores en la tabla ranking
            BaseDeDatos.insert("rankingNormal", null, registro);

            BaseDeDatos.close();

            et_nombre.setText("");

            //Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debes rellenar el nombre", Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarTop5 (View view){
        BaseDeDatos = BBDD.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("select nombre, puntuacion from rankingNormal", null);
        if(fila.moveToFirst()){
            mostrarRanking.setText(fila.getString(0));
            mostrarRanking.setText(fila.getString(1));
            Toast.makeText(this, "Muestro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No muestro", Toast.LENGTH_SHORT).show();
        }

        BaseDeDatos.close();
    }
}