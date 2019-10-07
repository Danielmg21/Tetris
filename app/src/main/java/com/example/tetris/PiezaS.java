package com.example.tetris;

public class PiezaS extends PiezasAll {
    public static int [] [] pos0 = {{7,4,4,7},
            {4,4,7,7},
            {7,7,7,7},
            {7,7,7,7}};
    public static int [] [] pos1 = {{7,4,7,7},
            {7,4,4,7},
            {7,7,4,7},
            {7,7,7,7}};
    public PiezaS(int identificador, int rotacion){
        super(identificador);
        setRotacion(rotacion);
    }
    @Override
    public void setRotacion(int rotacion){
        switch(rotacion){
            case 0:
                this.matriz = pos0;
                break;
            case 1:
                this.matriz = pos1;
                break;
        }
    }
    public static int [][] getPosicionS(int posicion){
        switch(posicion){
            case 0:
                return pos0;
            case 1:
                return pos1;
        }
        return pos0;
    }
}
