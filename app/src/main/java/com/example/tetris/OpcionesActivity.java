package com.example.tetris;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        Pieza p = new Pieza();
        if (seleccionC.equals("Rojo")) {
            p.setIdColor(7);
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }
        if (seleccionC.equals("Rosa")) {
            p.setIdColor(1);

        }
        if (seleccionC.equals("Azul Claro")) {

            p.setIdColor(2);

        }
        if (seleccionC.equals("Azul Oscuro")) {
            p.setIdColor(3);

        }
        if (seleccionC.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionC.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionC.equals("Amarrilo")) {
            p.setIdColor(6);

        }
        // Z Pieza
        String seleccionZ = sZ.getSelectedItem().toString();
        if (seleccionZ.equals("Rojo")) {
            p.setIdColor(7);
            // codigo set Z a rojo
        }
        if (seleccionZ.equals("Rosa")) {

            p.setIdColor(1);

        }
        if (seleccionZ.equals("Azul Claro")) {
            p.setIdColor(2);


        }
        if (seleccionZ.equals("Azul Oscuro")) {
            p.setIdColor(3);


        }
        if (seleccionZ.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionZ.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionZ.equals("Amarrilo")) {
            p.setIdColor(6);


        }

        // I Pieza
        String seleccionI = sI.getSelectedItem().toString();
        if (seleccionI.equals("Rojo")) {
            // codigo set I a rojo
            p.setIdColor(7);

        }
        if (seleccionI.equals("Rosa")) {
            p.setIdColor(1);


        }
        if (seleccionI.equals("Azul Claro")) {
            p.setIdColor(2);


        }
        if (seleccionI.equals("Azul Oscuro")) {
            p.setIdColor(3);


        }
        if (seleccionI.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionI.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionI.equals("Amarrilo")) {
            p.setIdColor(6);


        }

        // T Pieza
        String seleccionT = sT.getSelectedItem().toString();
        if (seleccionT.equals("Rojo")) {
            // codigo set T a rojo
            p.setIdColor(7);

        }
        if (seleccionT.equals("Rosa")) {
            p.setIdColor(1);


        }
        if (seleccionT.equals("Azul Claro")) {
            p.setIdColor(2);


        }
        if (seleccionT.equals("Azul Oscuro")) {
            p.setIdColor(3);


        }
        if (seleccionT.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionT.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionT.equals("Amarrilo")) {
            p.setIdColor(6);


        }

        // S Pieza
        String seleccionS = sS.getSelectedItem().toString();
        if (seleccionS.equals("Rojo")) {
            // codigo set S a rojo
            p.setIdColor(7);

        }
        if (seleccionS.equals("Rosa")) {
            p.setIdColor(1);


        }
        if (seleccionS.equals("Azul Claro")) {
            p.setIdColor(2);


        }
        if (seleccionS.equals("Azul Oscuro")) {
            p.setIdColor(3);


        }
        if (seleccionS.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionS.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionS.equals("Amarrilo")) {
            p.setIdColor(6);


        }

        // L Pieza
        String seleccionL = sL.getSelectedItem().toString();
        if (seleccionL.equals("Rojo")) {
            // codigo set L a rojo
            p.setIdColor(7);

        }
        if (seleccionL.equals("Rosa")) {
            p.setIdColor(1);


        }
        if (seleccionL.equals("Azul Claro")) {
            p.setIdColor(2);


        }
        if (seleccionL.equals("Azul Oscuro")) {
            p.setIdColor(3);


        }
        if (seleccionL.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionL.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionL.equals("Amarrilo")) {
            p.setIdColor(6);


        }

        // J Pieza
        String seleccionJ = sJ.getSelectedItem().toString();
        if (seleccionJ.equals("Rojo")) {
            // codigo set cuadrado a rojo
            p.setIdColor(7);

        }
        if (seleccionJ.equals("Rosa")) {
            p.setIdColor(1);


        }
        if (seleccionJ.equals("Azul Claro")) {
            p.setIdColor(2);


        }
        if (seleccionJ.equals("Azul Oscuro")) {
            p.setIdColor(3);


        }
        if (seleccionJ.equals("Verde")) {
            p.setIdColor(4);


        }
        if (seleccionJ.equals("Naranja")) {
            p.setIdColor(5);


        }
        if (seleccionJ.equals("Amarrilo")) {
            p.setIdColor(6);


        }


    }

}
