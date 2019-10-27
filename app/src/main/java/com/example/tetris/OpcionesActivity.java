package com.example.tetris;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class OpcionesActivity extends AppCompatActivity {
    private TextView tvCuadrado;
    private TextView tvZ;
    private TextView tvI;
    private TextView tvT;
    private TextView tvS;
    private TextView tvL;
    private TextView tvJ;
    private Spinner sCuadrado;
    private Spinner sZ;
    private Spinner sI;
    private Spinner sT;
    private Spinner sS;
    private Spinner sL;
    private Spinner sJ;
    private Button aplicarCambios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aplicarCambios = (Button)findViewById(R.id.button_Cambios);
        aplicarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcionesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        tvCuadrado = (TextView) findViewById(R.id.textView_CuadradoText);
        tvZ = (TextView) findViewById(R.id.textView_ZText);
        tvI = (TextView) findViewById(R.id.textView_IText);
        tvT = (TextView) findViewById(R.id.textView_TText);
        tvS = (TextView) findViewById(R.id.textView_SText);
        tvL = (TextView) findViewById(R.id.textView_LText);
        tvJ = (TextView) findViewById(R.id.textView_JText);

        sCuadrado = (Spinner) findViewById(R.id.spinnerCuadrado);
        sZ = (Spinner) findViewById(R.id.spinnerZPieza);
        sI = (Spinner) findViewById(R.id.spinnerIPieza);
        sT = (Spinner) findViewById(R.id.spinnerTPieza);
        sS = (Spinner) findViewById(R.id.spinnerSPieza);
        sL = (Spinner) findViewById(R.id.spinnerLPieza);
        sJ = (Spinner) findViewById(R.id.spinnerJPieza);

        String[] opciones = {"Rojo", "Rosa", "Azul Claro", "Azul Oscuro", "Verde", "Naranja", "Amarillo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);

        sCuadrado.setAdapter(adapter);
        sZ.setAdapter(adapter);
        sI.setAdapter(adapter);
        sT.setAdapter(adapter);
        sS.setAdapter(adapter);
        sL.setAdapter(adapter);
        sJ.setAdapter(adapter);
    }

    public void SetColor(View view) {                            //id:4 = verde, id:6 = amarillo, id:5 = naranja, id: 2 = azul claro, id:1 = rosa, id:3 = azul oscuro, id:7 = rojo
        // Cuadrado

        String seleccionC = sCuadrado.getSelectedItem().toString();

        if (seleccionC.equals("Rojo")) {
            Tablero.setColorCuadrado(7);
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }
        if (seleccionC.equals("Rosa")) {
            Tablero.setColorCuadrado(1);
        }
        if (seleccionC.equals("Azul Claro")) {
            Tablero.setColorCuadrado(2);
        }
        if (seleccionC.equals("Azul Oscuro")) {
            Tablero.setColorCuadrado(3);
        }
        if (seleccionC.equals("Verde")) {
            Tablero.setColorCuadrado(4);
        }
        if (seleccionC.equals("Naranja")) {
            Tablero.setColorCuadrado(5);
        }
        if (seleccionC.equals("Amarrilo")) {
            Tablero.setColorCuadrado(6);
        }

        // Z Pieza
        String seleccionZ = sZ.getSelectedItem().toString();
        if (seleccionZ.equals("Rojo")) {
            Tablero.setColorZPieza(7);
            // codigo set Z a rojo
        }
        if (seleccionZ.equals("Rosa")) {
            Tablero.setColorZPieza(1);
        }
        if (seleccionZ.equals("Azul Claro")) {
            Tablero.setColorZPieza(2);
        }
        if (seleccionZ.equals("Azul Oscuro")) {
            Tablero.setColorZPieza(3);
        }
        if (seleccionZ.equals("Verde")) {
            Tablero.setColorZPieza(4);
        }
        if (seleccionZ.equals("Naranja")) {
            Tablero.setColorZPieza(5);
        }
        if (seleccionZ.equals("Amarrilo")) {
            Tablero.setColorZPieza(6);


        }

        // I Pieza
        String seleccionI = sI.getSelectedItem().toString();
        if (seleccionI.equals("Rojo")) {
            // codigo set I a rojo
            Tablero.setColorIPieza(7);

        }
        if (seleccionI.equals("Rosa")) {
            Tablero.setColorIPieza(1);


        }
        if (seleccionI.equals("Azul Claro")) {
            Tablero.setColorIPieza(2);


        }
        if (seleccionI.equals("Azul Oscuro")) {
            Tablero.setColorIPieza(3);


        }
        if (seleccionI.equals("Verde")) {
            Tablero.setColorIPieza(4);


        }
        if (seleccionI.equals("Naranja")) {
            Tablero.setColorIPieza(5);


        }
        if (seleccionI.equals("Amarrilo")) {
            Tablero.setColorIPieza(6);


        }

        // T Pieza
        String seleccionT = sT.getSelectedItem().toString();
        if (seleccionT.equals("Rojo")) {
            // codigo set T a rojo
            Tablero.setColorTPieza(7);

        }
        if (seleccionT.equals("Rosa")) {
            Tablero.setColorTPieza(1);


        }
        if (seleccionT.equals("Azul Claro")) {
            Tablero.setColorTPieza(2);


        }
        if (seleccionT.equals("Azul Oscuro")) {
            Tablero.setColorTPieza(3);


        }
        if (seleccionT.equals("Verde")) {
            Tablero.setColorTPieza(4);


        }
        if (seleccionT.equals("Naranja")) {
            Tablero.setColorTPieza(5);


        }
        if (seleccionT.equals("Amarrilo")) {
            Tablero.setColorTPieza(6);


        }

        // S Pieza
        String seleccionS = sS.getSelectedItem().toString();
        if (seleccionS.equals("Rojo")) {
            // codigo set S a rojo
            Tablero.setColorSPieza(7);

        }
        if (seleccionS.equals("Rosa")) {
            Tablero.setColorSPieza(1);


        }
        if (seleccionS.equals("Azul Claro")) {
            Tablero.setColorSPieza(2);


        }
        if (seleccionS.equals("Azul Oscuro")) {
            Tablero.setColorSPieza(3);


        }
        if (seleccionS.equals("Verde")) {
            Tablero.setColorSPieza(4);


        }
        if (seleccionS.equals("Naranja")) {
            Tablero.setColorSPieza(5);


        }
        if (seleccionS.equals("Amarrilo")) {
            Tablero.setColorSPieza(6);


        }

        // L Pieza
        String seleccionL = sL.getSelectedItem().toString();
        if (seleccionL.equals("Rojo")) {
            // codigo set L a rojo
            Tablero.setColorLPieza(7);

        }
        if (seleccionL.equals("Rosa")) {
            Tablero.setColorLPieza(1);


        }
        if (seleccionL.equals("Azul Claro")) {
            Tablero.setColorLPieza(2);


        }
        if (seleccionL.equals("Azul Oscuro")) {
            Tablero.setColorLPieza(3);


        }
        if (seleccionL.equals("Verde")) {
            Tablero.setColorLPieza(4);


        }
        if (seleccionL.equals("Naranja")) {
            Tablero.setColorLPieza(5);


        }
        if (seleccionL.equals("Amarrilo")) {
            Tablero.setColorLPieza(6);


        }

        // J Pieza
        String seleccionJ = sJ.getSelectedItem().toString();
        if (seleccionJ.equals("Rojo")) {
            // codigo set cuadrado a rojo
            Tablero.setColorJPieza(7);

        }
        if (seleccionJ.equals("Rosa")) {
            Tablero.setColorJPieza(1);


        }
        if (seleccionJ.equals("Azul Claro")) {
            Tablero.setColorJPieza(2);


        }
        if (seleccionJ.equals("Azul Oscuro")) {
            Tablero.setColorJPieza(3);


        }
        if (seleccionJ.equals("Verde")) {
            Tablero.setColorJPieza(4);


        }
        if (seleccionJ.equals("Naranja")) {
            Tablero.setColorJPieza(5);


        }
        if (seleccionJ.equals("Amarrilo")) {
            Tablero.setColorJPieza(6);


        }


    }

}
