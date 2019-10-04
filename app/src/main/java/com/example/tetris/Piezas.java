package com.example.tetris;


import java.util.ArrayList;

public class Piezas {

    public int [][] matriz = new int [4][4];
    public int identificador = 7 ;

    public Piezas(int identificador) {
        this.identificador = identificador;
        switch (identificador) {
            case 0:
                I_Piece pieza0 = new I_Piece();
                break;
            case 1:
                J_Piece pieza1 = new J_Piece();
                break;
            case 2:
                Z_Piece pieza2 = new Z_Piece();
                break;
            case 3:
                L_Piece pieza3 = new L_Piece();
                break;
            case 4:
                S_Piece pieza4 = new S_Piece();
                break;
            case 5:
                O_Piece pieza5 = new O_Piece();
                break;
            case 6:
                T_Piece pieza6 = new T_Piece();
                break;

        }
    }

    public void Girar (int [][] m, int id, int [] l){
        int val = id;
        int posPieza;
        int posicionPieza = l[val];
        switch (val) {
            case 0://pieza en forma de I
                if (posicionPieza==1) {
                   posicionPieza=0;
                } else {
                    posicionPieza++;
                }

                switch(posicionPieza){
                    case 0:
                        matriz = I_Piece.pos0;
                        break;
                    case 1:
                        matriz = I_Piece.pos1;
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
                        matriz = J_Piece.pos0;
                        break;
                    case 1:
                        matriz = J_Piece.pos1;
                        break;
                    case 2:
                        matriz = J_Piece.pos2;
                        break;
                    case 3:
                        matriz = J_Piece.pos3;
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
                        matriz = Z_Piece.pos0;
                        break;
                    case 1:
                        matriz = Z_Piece.pos1;
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
                        matriz = L_Piece.pos0;
                        break;
                    case 1:
                        matriz = L_Piece.pos1;
                        break;
                    case 2:
                        matriz = L_Piece.pos2;
                        break;
                    case 3:
                        matriz = L_Piece.pos3;
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
                        matriz = S_Piece.pos0;
                        break;
                    case 1:
                        matriz = S_Piece.pos1;
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
                        matriz = T_Piece.pos0;
                        break;
                    case 1:
                        matriz = T_Piece.pos1;
                        break;
                    case 2:
                        matriz = T_Piece.pos2;
                        break;
                    case 3:
                        matriz = T_Piece.pos3;
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

    public static class I_Piece{
        public static int [] [] pos0 = {{7,7,7,7},
                {0,0,0,0},
                {7,7,7,7},
                {7,7,7,7}};
        public static int [] [] pos1 = {{7,0,7,7},
                {7,0,7,7},
                {7,0,7,7},
                {7,0,7,7}};

    }
    public static class J_Piece{
        public static int [] [] pos0 = {{7,1,7,7},
                {7,1,1,1},
                {7,7,7,7},
                {7,7,7,7}};
        public static int [] [] pos1 = {{7,1,1,7},
                {7,1,7,7},
                {7,1,7,7},
                {7,7,7,7}};
        public static int [] [] pos2 = {{1,1,1,7},
                {7,7,1,7},
                {7,7,7,7},
                {7,7,7,7}};
        public static int [] [] pos3 = {{7,7,1,7},
                {7,7,1,7},
                {7,1,1,7},
                {7,7,7,7}};

    }
    public static class Z_Piece{
        public static int [] [] pos0 = {{7,2,2,7},
                {7,7,2,2},
                {7,7,7,7},
                {7,7,7,7}};
        public static int [] [] pos1 = {{7,7,2,7},
                {7,2,2,7},
                {7,2,7,7},
                {7,7,7,7}};

    }
    public static class L_Piece{
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

    }
    public static class S_Piece{
        public static int [] [] pos0 = {{7,4,4,7},
                {4,4,7,7},
                {7,7,7,7},
                {7,7,7,7}};
        public static int [] [] pos1 = {{7,4,7,7},
                {7,4,4,7},
                {7,7,4,7},
                {7,7,7,7}};


    }
    public class O_Piece{
        public int [] [] posx = {{7,5,5,7},
                {7,5,5,7},
                {7,7,7,7},
                {7,7,7,7}};


    }
    public static class T_Piece{
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

    }

}
