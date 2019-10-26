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
    private TextView mostrarRanking1,mostrarRanking2,mostrarRanking3,mostrarRanking4,mostrarRanking5,mostrarRanking6,mostrarPunt1,mostrarPunt2,mostrarPunt3,mostrarPunt4,mostrarPunt5,mostrarPunt6;
    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private boolean registrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BBDD = new AdminSQLiteOpenHelper(this, "RankingJugadores", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        Button again = findViewById(R.id.Again);
        Button exit = findViewById(R.id.exit);
        registrar = findViewById(R.id.registrar_puntuacion);
        TextView nombre = findViewById(R.id.nombre_jugador);
        registrado=false;

        mostrarRanking1 = findViewById(R.id.mostrarRanking1);
        mostrarRanking2 = findViewById(R.id.mostrarRanking2);
        mostrarRanking3 = findViewById(R.id.mostrarRanking3);
        mostrarRanking4 = findViewById(R.id.mostrarRanking4);
        mostrarRanking5 = findViewById(R.id.mostrarRanking5);
        mostrarRanking6 = findViewById(R.id.mostrarRanking6);

        mostrarPunt1= findViewById(R.id.textpunt1);
        mostrarPunt2= findViewById(R.id.textpunt2);
        mostrarPunt3= findViewById(R.id.textpunt3);
        mostrarPunt4= findViewById(R.id.textpunt4);
        mostrarPunt5= findViewById(R.id.textpunt5);
        mostrarPunt6= findViewById(R.id.textpunt6);




        et_nombre = (EditText)findViewById(R.id.nombre_jugador);

        //mostrarTop5();

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
                mostrarTop5();

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

        if (!nombre.isEmpty() & !registrado){
            //permite almacenar las columnas del registro en pares clave-valor
            ContentValues registro = new ContentValues();
            //Añade los pares
            registro.put("nombre", nombre);
            registro.put("puntuacion", 60);

            //insertar valores en la tabla ranking
            BaseDeDatos.insert("rankingNormal", null, registro);

            BaseDeDatos.close();

            et_nombre.setText("");
            registrado=true;
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        }else{
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Debes rellenar el nombre", Toast.LENGTH_SHORT).show();
            }
            if (registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void mostrarTop5 (){
        BaseDeDatos = BBDD.getReadableDatabase();
        String columnas[] = new String[]{"nombre","puntuacion"};//,"puntuacion"

        String j1="",j2="",j3="",j4="",j5="",j6="",p1="",p2="",p3="",p4="",p5="",p6="";

        //********************** AMBAS FUNCIONAN
        //-----1 forma
            Cursor fila1 =BaseDeDatos.rawQuery("select * from rankingNormal order by puntuacion DESC",null);

        //-----2 forma
            //Cursor fila2 = BaseDeDatos.query("rankingNormal", columnas, null, null, null, null, "puntuacion"+" DESC");
        if(fila1.moveToFirst()){
            //mostrarRanking.setText(fila1.getString(0)+fila1.getString(1));

            j1 = fila1.getString(0);
            p1 = fila1.getString(1);

            if (fila1.moveToNext()) {
                fila1.moveToNext();
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                fila1.moveToNext();
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                fila1.moveToNext();
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                fila1.moveToNext();
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);
            }
            if (fila1.moveToNext()) {
                fila1.moveToNext();
                j6 = fila1.getString(0);
                p6= fila1.getString(1);
            }

            Toast.makeText(this, "Muestro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Ranking vacio", Toast.LENGTH_SHORT).show();
            j1="";
            j2="";
            j3="";
            j4="";
            j5="";
            j6="";
            p1="";
            p2="";
            p3="";
            p4="";
            p5="";
            p6="";
        }

        mostrarRanking1.setText(j1);
        mostrarRanking2.setText(j2);
        mostrarRanking3.setText(j3);
        mostrarRanking4.setText(j4);
        mostrarRanking5.setText(j5);
        mostrarRanking6.setText(j6);

        mostrarPunt1.setText(p1);
        mostrarPunt2.setText(p2);
        mostrarPunt3.setText(p3);
        mostrarPunt4.setText(p4);
        mostrarPunt5.setText(p5);
        mostrarPunt6.setText(p6);

        BaseDeDatos.close();
    }

    public void restablecerEstadiaticas (View view){
        BaseDeDatos = BBDD.getWritableDatabase();

        BaseDeDatos.execSQL("DELETE FROM rankingNormal");
        /*
        Cursor fila1 =BaseDeDatos.rawQuery("select * from rankingNormal",null);

        if (fila1 != null) {
            fila1.moveToFirst();
            do{
                BaseDeDatos.execSQL("DELETE FROM rankingNormal");

            }while (fila1.moveToNext())
        }
        fila1.close();
        */
        Toast.makeText(this, "Estadisticas restablecidas", Toast.LENGTH_SHORT).show();
        BaseDeDatos.close();

        mostrarTop5();
    }


}