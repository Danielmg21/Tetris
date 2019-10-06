package com.example.tetris;


import android.content.Context;
import android.view.View;

import java.util.ArrayList;

import static com.example.tetris.PiezaI.getPosicionI;
import static com.example.tetris.PiezaJ.getPosicionJ;
import static com.example.tetris.PiezaZ.getPosicionZ;
import static com.example.tetris.PiezaL.getPosicionL;
import static com.example.tetris.PiezaS.getPosicionS;
import static com.example.tetris.PiezaO.getPosicionO;
import static com.example.tetris.PiezaT.getPosicionT;

public class PiezasAll {

    protected int [][] matriz = new int [4][4];
    protected int identificador = 7 ;
    protected Coordenada coor = new Coordenada(0,0);
    protected int rotacion;

    public ArrayList<Coordenada> obtenerPosiciones(PiezasAll p){
        ArrayList<Coordenada> l = new ArrayList<>();
        for (int y=0;y<4;y++){
            for (int x=0;x <4;x++){
                if (p.matriz[x][y]!= 7){
                    Coordenada pepe = new Coordenada(x,y);
                    l.add(pepe);
                }
            }
        }
        return l;
    }

    public PiezasAll(int identificador) {
        this.identificador = identificador;
        this.rotacion = 0;
        switch (identificador) {
            case 0:
                this.matriz = getPosicionI(0);
                break;
            case 1:
                this.matriz = getPosicionJ(0);
                break;
            case 2:
                this.matriz = getPosicionZ(0);
                break;
            case 3:
                this.matriz = getPosicionL(0);
                break;
            case 4:
                this.matriz = getPosicionS(0);
                break;
            case 5:
                this.matriz = getPosicionO();
                break;
            case 6:
                this.matriz = getPosicionT(0);
                break;
        }
    }
    public PiezasAll(int identificador, int rotacion) {
        this.identificador = identificador;
        this.rotacion = rotacion;
        switch (identificador) {
            case 0:
                this.matriz = getPosicionI(rotacion);
                break;
            case 1:
                this.matriz = getPosicionJ(rotacion);
                break;
            case 2:
                this.matriz = getPosicionZ(rotacion);
                break;
            case 3:
                this.matriz = getPosicionL(rotacion);
                break;
            case 4:
                this.matriz = getPosicionS(rotacion);
                break;
            case 5:
                this.matriz = getPosicionO();
                break;
            case 6:
                this.matriz = getPosicionT(rotacion);
                break;
        }
    }

    public PiezasAll() {
    }

    public void Girar (PiezasAll pieza){
        int id = pieza.getIdentificador();
        int posaux;
        switch (id) {
            case 0://pieza en forma de I
                if (pieza.getRotacion()==1) {
                   pieza.setRotacion(0);
                } else {
                    pieza.setRotacion(1);
                }
                break;

            case 1:// pieza en forma de J
                if (pieza.getRotacion()==3) {
                    pieza.setRotacion(0);
                } else {
                    posaux = pieza.getRotacion();
                    switch(posaux) {
                    case 0:
                        pieza.setRotacion(1);
                        break;
                    case 1:
                        pieza.setRotacion(2);
                        break;
                    case 2:
                        pieza.setRotacion(3);
                        break;
                    }
                }
                break;

            case 2:// Pieza en forma de Z
                if (pieza.getRotacion()==0) {
                    pieza.setRotacion(1);
                } else {
                    pieza.setRotacion(0);
                }
                break;

            case 3:// Pieza en forma de L
                if (pieza.getRotacion()==0) {
                    pieza.setRotacion(1);
                } else {
                    posaux = pieza.getRotacion();
                    switch(posaux) {
                        case 1:
                            pieza.setRotacion(2);
                            break;
                        case 2:
                            pieza.setRotacion(3);
                            break;
                        case 3:
                            pieza.setRotacion(0);
                            break;
                    }
                }
                break;

            case 4:// Pieza en forma de S
                posaux = pieza.getRotacion();
                switch(posaux) {
                    case 0:
                        pieza.setRotacion(1);
                        break;
                    case 1:
                        pieza.setRotacion(0);
                        break;
                }

            case 5: // Pieza en forma de O
                pieza.setRotacion(0);
                break;

            case 6: //Pieza en forma de T
                    posaux = pieza.getRotacion();
                    switch(posaux) {
                        case 0:
                            pieza.setRotacion(1);
                            break;
                        case 1:
                            pieza.setRotacion(2);
                            break;
                        case 2:
                            pieza.setRotacion(3);
                            break;
                        case 3:
                            pieza.setRotacion(0);
                            break;
                    }
                }

    }
    public int getIdentificador() {
        return identificador;
    }

    public int getRotacion() {
        return rotacion;
    }

    public void setRotacion(int rotacion) {
        this.rotacion = rotacion;
    }
    /* public int [] [] posx = {{7,7,7,7},
                                {7,7,7,7},
                                {7,7,7,7},
                                {7,7,7,7}};

     */
}
