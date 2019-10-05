package com.example.tetris;

public class PiezaI extends Piezas{
        public static int [] [] pos0 = {{7,7,7,7},
                {0,0,0,0},
                {7,7,7,7},
                {7,7,7,7}};
        public static int [] [] pos1 = {{7,0,7,7},
                {7,0,7,7},
                {7,0,7,7},
                {7,0,7,7}};

    public PiezaI (int identificador, int posicion){
        super(identificador);
        setPosicionI(posicion);
    }
    public void setPosicionI(int posicion){
        switch(posicion){
            case 0:
                this.matriz = pos0;
                break;
            case 1:
                this.matriz = pos1;
                break;
        }
    }
    public static int [][] getPosicionI(int posicion){
        switch(posicion){
            case 0:
                return pos0;
            case 1:
                return pos1;
        }
        return pos0;
    }
}

