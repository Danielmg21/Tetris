package com.example.tetris;

import androidx.annotation.RawRes;

public class Cancion {

    int ruta;
    boolean escogida,disp;

    public Cancion(@RawRes int ruta, boolean escogida, boolean disp){
        this.ruta = ruta;
        this.escogida = escogida;
        this.disp = disp;
    }
}
