package com.example.tetris;



public class Pieces {

    public static int [][] matriz = new int [4][4];
    public static int identificador = 7 ;

    public void Girar (int [][] m, int id){

    }

    /* public int [] [] posx = {{7,7,7,7},
                                {7,7,7,7},
                                {7,7,7,7},
                                {7,7,7,7}};

     */

    public class I_Piece{
        public int [] [] pos0 = {{7,7,7,7},
                {0,0,0,0},
                {7,7,7,7},
                {7,7,7,7}};
        public int [] [] pos1 = {{7,0,7,7},
                {7,0,7,7},
                {7,0,7,7},
                {7,0,7,7}};
        public int pos=0;

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
        public int pos=0;

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
        public int pos=0;

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
        public int pos=0;
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

        public int pos=0;
    }
    public class O_Piece{
        public int [] [] posx = {{7,5,5,7},
                {7,5,5,7},
                {7,7,7,7},
                {7,7,7,7}};

        public int pos=0;

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
        public int pos=0;

    }

}
