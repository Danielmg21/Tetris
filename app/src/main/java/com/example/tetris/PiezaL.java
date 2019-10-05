package com.example.tetris;

public class PiezaL extends Piezas {
    public static int [] [] pos0 = {{7,7,3,7},
            {3,3,3,7},
            {7,7,7,7},
            {7,7,7,7}};
    public static int [] [] pos1 = {{7,3,7,7},
            {7,3,7,7},
            {7,3,3,7},
            {7,7,7,7}};
    public static int [] [] pos2 = {{7,3,3,3},
            {7,3,7,7},
            {7,7,7,7},
            {7,7,7,7}};
    public static int [] [] pos3 = {{7,3,3,7},
            {7,7,3,7},
            {7,7,3,7},
            {7,7,7,7}};

    public PiezaL (int identificador, int posicion){
        super(identificador);
        setPosicionL(posicion);
    }
    public void setPosicionL(int posicion){
        switch(posicion){
            case 0:
                this.matriz = pos0;
                break;
            case 1:
                this.matriz = pos1;
                break;
        }
    }
    public static int [][] getPosicionL(int posicion){
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

