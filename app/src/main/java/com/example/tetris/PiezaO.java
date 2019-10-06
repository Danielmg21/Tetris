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
    public void setPosicionO(int posicion){
        switch(posicion){
            case 0:
                this.matriz = posx;
                break;
        }
    }
    public static int [][] getPosicionO(int posicion){
        switch(posicion){
            case 0:
                return posx;
        }
        return posx;
    }
}
