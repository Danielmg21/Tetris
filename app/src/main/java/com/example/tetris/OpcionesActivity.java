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

        tvCuadrado = (TextView)findViewById(R.id.textView_CuadradoText);
        tvZ = (TextView)findViewById(R.id.textView_ZText);
        tvI = (TextView)findViewById(R.id.textView_IText);
        tvT = (TextView)findViewById(R.id.textView_TText);
        tvS = (TextView)findViewById(R.id.textView_SText);
        tvL = (TextView)findViewById(R.id.textView_LText);
        tvJ = (TextView)findViewById(R.id.textView_JText);

        sCuadrado = (Spinner)findViewById(R.id.spinnerCuadrado);
        sZ = (Spinner)findViewById(R.id.spinnerZPieza);
        sI = (Spinner)findViewById(R.id.spinnerIPieza);
        sT = (Spinner)findViewById(R.id.spinnerTPieza);
        sS = (Spinner)findViewById(R.id.spinnerSPieza);
        sL = (Spinner)findViewById(R.id.spinnerLPieza);
        sJ = (Spinner)findViewById(R.id.spinnerJPieza);

        String [] opciones = {"Rojo", "Rosa", "Azul Claro", "Azul Oscuro", "Verde", "Naranja", "Amarillo"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);

        sCuadrado.setAdapter(adapter);
        sZ.setAdapter(adapter);
        sI.setAdapter(adapter);
        sT.setAdapter(adapter);
        sS.setAdapter(adapter);
        sL.setAdapter(adapter);
        sJ.setAdapter(adapter);
    }

    public void SetColor(View view){
        // Cuadrado
        String seleccionC = sCuadrado.getSelectedItem().toString();
        if(seleccionC.equals("Rojo")){
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }if(seleccionC.equals("Rosa")){

        }if(seleccionC.equals("Azul Claro")){

        }if(seleccionC.equals("Azul Oscuro")){

        }if(seleccionC.equals("Verde")){

        }if(seleccionC.equals("Naranja")){

        }if(seleccionC.equals("Amarrilo")){

        }
        // Z Pieza
        String seleccionZ = sZ.getSelectedItem().toString();
        if(seleccionZ.equals("Rojo")){
            // codigo set Z a rojo
        }if(seleccionZ.equals("Rosa")){

        }if(seleccionZ.equals("Azul Claro")){

        }if(seleccionZ.equals("Azul Oscuro")){

        }if(seleccionZ.equals("Verde")){

        }if(seleccionZ.equals("Naranja")){

        }if(seleccionZ.equals("Amarrilo")){

        }

        // I Pieza
        String seleccionI = sI.getSelectedItem().toString();
        if(seleccionI.equals("Rojo")){
            // codigo set I a rojo
        }if(seleccionI.equals("Rosa")){

        }if(seleccionI.equals("Azul Claro")){

        }if(seleccionI.equals("Azul Oscuro")){

        }if(seleccionI.equals("Verde")){

        }if(seleccionI.equals("Naranja")){

        }if(seleccionI.equals("Amarrilo")){

        }

        // T Pieza
        String seleccionT = sT.getSelectedItem().toString();
        if(seleccionT.equals("Rojo")){
            // codigo set T a rojo
        }if(seleccionT.equals("Rosa")){

        }if(seleccionT.equals("Azul Claro")){

        }if(seleccionT.equals("Azul Oscuro")){

        }if(seleccionT.equals("Verde")){

        }if(seleccionT.equals("Naranja")){

        }if(seleccionT.equals("Amarrilo")){

        }

        // S Pieza
        String seleccionS = sS.getSelectedItem().toString();
        if(seleccionS.equals("Rojo")){
            // codigo set S a rojo
        }if(seleccionS.equals("Rosa")){

        }if(seleccionS.equals("Azul Claro")){

        }if(seleccionS.equals("Azul Oscuro")){

        }if(seleccionS.equals("Verde")){

        }if(seleccionS.equals("Naranja")){

        }if(seleccionS.equals("Amarrilo")){

        }

        // L Pieza
        String seleccionL = sL.getSelectedItem().toString();
        if(seleccionL.equals("Rojo")){
            // codigo set L a rojo
        }if(seleccionL.equals("Rosa")){

        }if(seleccionL.equals("Azul Claro")){

        }if(seleccionL.equals("Azul Oscuro")){

        }if(seleccionL.equals("Verde")){

        }if(seleccionL.equals("Naranja")){

        }if(seleccionL.equals("Amarrilo")){

        }

        // J Pieza
        String seleccionJ = sJ.getSelectedItem().toString();
        if(seleccionJ.equals("Rojo")){
            // codigo set cuadrado a rojo
        }if(seleccionJ.equals("Rosa")){

        }if(seleccionJ.equals("Azul Claro")){

        }if(seleccionJ.equals("Azul Oscuro")){

        }if(seleccionJ.equals("Verde")){

        }if(seleccionJ.equals("Naranja")){

        }if(seleccionJ.equals("Amarrilo")){

        }


    }

}
