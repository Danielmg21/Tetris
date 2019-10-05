package com.example.tetris;

public class PiezaT extends PiezasAll{
    public static int [] [] pos0 = {{7,7,6,7},
            {7,6,6,6},
            {7,7,7,7},
            {7,7,7,7}};
    public static  int [] [] pos1 = {{7,6,7,7},
            {7,6,6,7},
            {7,6,7,7},
            {7,7,7,7}};
    public static int [] [] pos2 = {{7,6,6,6},
            {7,7,6,7},
            {7,7,7,7},
            {7,7,7,7}};
    public static int [] [] pos3 = {{7,7,6,7},
            {7,6,6,7},
            {7,7,6,7},
            {7,7,7,7}};
    public PiezaT (int identificador, int posicion){
        super(identificador);
        setPosicionT(posicion);
    }
    public void setPosicionT(int posicion){
        switch(posicion){
            case 0:
                this.matriz = pos0;
                break;
            case 1:
                this.matriz = pos1;
                break;
        }
    }
    public static int [][] getPosicionT(int posicion){
        switch(posicion){
            case 0:
                return pos0;
            case 1:
                return pos1;
            case 2:
                return pos2;
            case 3:
                return pos3;
        }
        return pos0;
    }
}
