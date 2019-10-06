package com.example.tetris;

public class PiezaO extends PiezasAll{
    public static int [] [] posx = {{7,5,5,7},
            {7,5,5,7},
            {7,7,7,7},
            {7,7,7,7}};
    public PiezaO (int identificador, int posicion){
        super(identificador);
        setPosicionO(posicion);
    }
    public void setPosicionO(int rotacion){
        this.rotacion = rotacion;
        this.matriz = posx;
    }
    public static int [][] getPosicionO(){
        return posx;
    }
}
