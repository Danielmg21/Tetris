package com.example.tetris;


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

    public ArrayList<Coordenada> ObtenerPosiciones(PiezasAll p){
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
        this.rotacion=0;
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
                this.matriz = getPosicionO(0);
                break;
            case 6:
                this.matriz = getPosicionT(0);
                break;
        }
    }

    public PiezasAll() {

    }

    public void Girar (int [][] m, int id, int posicionPieza){
        int val = id;
        switch (val) {
            case 0://pieza en forma de I
                if (posicionPieza==1) {
                   posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = getPosicionI(0);
                        break;
                    case 1:
                        matriz = getPosicionI(1);
                        break;
                }
                break;

            case 1:// pieza en forma de J
                if (posicionPieza==3) {
                    posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = getPosicionJ(0);
                        break;
                    case 1:
                        matriz = getPosicionJ(1);
                        break;
                    case 2:
                        matriz = getPosicionJ(2);
                        break;
                    case 3:
                        matriz = getPosicionJ(3);
                        break;
                }
                break;

            case 2:// Pieza en forma de Z
                if (posicionPieza==1) {
                    posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = getPosicionZ(0);
                        break;
                    case 1:
                        matriz = getPosicionZ(1);
                        break;
                }
                break;

            case 3:// Pieza en forma de L
                if (posicionPieza==3) {
                    posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = getPosicionL(0);
                        break;
                    case 1:
                        matriz = getPosicionL(1);
                        break;
                    case 2:
                        matriz = getPosicionL(2);
                        break;
                    case 3:
                        matriz = getPosicionL(3);
                        break;
                }
                break;

            case 4:// Pieza en forma de S
                if (posicionPieza==1) {
                    posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = getPosicionS(0);
                        break;
                    case 1:
                        matriz = getPosicionS(1);
                        break;
                }
                break;

            case 5:

                break;

            case 6:
                if (posicionPieza==3) {
                    posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = getPosicionT(0);
                        break;
                    case 1:
                        matriz = getPosicionT(1);
                        break;
                    case 2:
                        matriz = getPosicionT(2);
                        break;
                    case 3:
                        matriz = getPosicionT(3);
                        break;
                }
                break;
        }



    }

    /* public int [] [] posx = {{7,7,7,7},
                                {7,7,7,7},
                                {7,7,7,7},
                                {7,7,7,7}};

     */


}
