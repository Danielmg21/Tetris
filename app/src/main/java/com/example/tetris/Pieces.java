package com.example.tetris;


import java.util.ArrayList;

public class Pieces {

    public int [][] matriz = new int [4][4];
    public int identificador = 7 ;

    public void Girar (int [][] m, int id,  int [] l){
        int val = id;
        int posPieza;
        int posicionPieza = l[val];
        switch (val) {
            case 0:
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

            case 1:
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

            case 2:
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

            case 3:
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

            case 4:
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

            case 5:
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

            case 6:
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
    public class J_Piece{
        public int [] [] pos0 = {{7,1,7,7},
                {7,1,1,1},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos1 = {{7,1,1,7},
                {7,1,7,7},
                {7,1,7,7},
                {7,7,7,7}};
        public int [] [] pos2 = {{1,1,1,7},
                {7,7,1,7},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos3 = {{7,7,1,7},
                {7,7,1,7},
                {7,1,1,7},
                {7,7,7,7}};

    }
    public class Z_Piece{
        public int [] [] pos0 = {{7,2,2,7},
                {7,7,2,2},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos1 = {{7,7,2,7},
                {7,2,2,7},
                {7,2,7,7},
                {7,7,7,7}};

    }
    public class L_Piece{
        public int [] [] pos0 = {{7,7,3,7},
                {3,3,3,7},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos1 = {{7,3,7,7},
                {7,3,7,7},
                {7,3,3,7},
                {7,7,7,7}};
        public int [] [] pos2 = {{7,3,3,3},
                {7,3,7,7},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos3 = {{7,3,3,7},
                {7,7,3,7},
                {7,7,3,7},
                {7,7,7,7}};

    }
    public class S_Piece{
        public int [] [] pos0 = {{7,4,4,7},
                {4,4,7,7},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos1 = {{7,4,7,7},
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
    public class T_Piece{
        public int [] [] pos0 = {{7,7,6,7},
                {7,6,6,6},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos1 = {{7,6,7,7},
                {7,6,6,7},
                {7,6,7,7},
                {7,7,7,7}};
        public int [] [] pos2 = {{7,6,6,6},
                {7,7,6,7},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos3 = {{7,7,6,7},
                {7,6,6,7},
                {7,7,6,7},
                {7,7,7,7}};

    }

}
