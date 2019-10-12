package com.example.tetris;

public class Pieza {

    public int idColor;
    public int x1, y1;
    public int x2, y2;
    public int x3, y3;
    public int x4, y4;
    private Pieza pieza;


    public Pieza(Pieza pieza) {
        this.pieza = pieza;
        this.x1= pieza.x1; this.x2= pieza.x2;
        this.x3= pieza.x3; this.x4= pieza.x4;
        this.y1= pieza.y1; this.y2= pieza.y2;
        this.y3= pieza.y3; this.y4= pieza.y4;
    }



    public Pieza(int f) {
        switch (f) { // Cuadrado
            case 1:
                x1 = 1; y1 = 7;
                x2 = 1; y2 = 8;
                x3 = 2; y3 = 7;
                x4 = 2; y4 = 8;

                idColor = 1;
                break;

            case 2:    // z Pieza
                x1 = 1;y1 = 7;
                x2 = 1;y2 = 8;
                x3 = 2;y3 = 8;
                x4 = 2;y4 = 9;

                idColor = 2;
                break;

            case 3: // I Pieza
                x1 = 0;y1 = 6;
                x2 = 0;y2 = 7;
                x3 = 0;y3 = 8;
                x4 = 0;y4 = 9;

                idColor = 3;
                break;

            case 4: // T Pieza
                x1 = 0;y1 = 8;
                x2 = 1;y2 = 7;
                x3 = 1;y3 = 8;
                x4 = 1;y4 = 9;

                idColor = 4;
                break;

            case 5: // S Pieza
                x1 = 0;y1 = 7;
                x2 = 0;y2 = 8;
                x3 = 1;y3 = 6;
                x4 = 1;y4 = 7;

                idColor = 5;
                break;

            case 6:  // J Pieza
                x1 = 0;y1 = 7;
                x2 = 0;y2 = 8;
                x3 = 0;y3 = 9;
                x4 = 1;y4 = 9;

                idColor = 6;
                break;

            case 7:  //  L Pieza
                x1 = 0;y1 = 7;
                x2 = 0;y2 = 8;
                x3 = 0;y3 = 9;
                x4 = 1;y4 = 7;

                idColor = 7;
                break;
        }
    }


    public void moverPieza() {
        int new_x1, new_y1;
        int new_x2, new_y2;
        int new_x3, new_y3;

        new_x1 = giraX1(y2);
        new_y1 = giraY1(x2);
        x2 = new_x1;
        y2 = new_y1;

        new_x2 = giraX1(y3);
        new_y2 = giraY1(x3);
        x3 = new_x2;
        y3 = new_y2;

        new_x3 = giraX1(y4);
        new_y3 = giraY1(x4);
        x4 = new_x3;
        y4 = new_y3;
    }

    public void mover(int x, int y) {
        x1 = x1 + x;
        y1 = y1 + y;
        x2 = x2 + x;
        y2 = y2 + y;
        x3 = x3 + x;
        y3 = y3 + y;
        x4 = x4 + x;
        y4 = y4 + y;
    }



    public int giraX1(int y) {
        return x1 + y - y1;
    }

    public int giraY1(int x) {
        return y1 - x + x1;
    }

    public void GirarPieza(){
        //gira la pieza en funcion de las coordenadas x1,y1
        //cada bloque gira un cuadradito

        int x_falsa; int y_falsa;


        x_falsa=giraX1(x2);
        y_falsa=giraY1(y2);
        x2=x_falsa;
        y2=y_falsa;

        x_falsa=giraX1(x3);
        y_falsa=giraY1(y3);
        x2=x_falsa;
        y2=y_falsa;

        x_falsa=giraX1(x4);
        y_falsa=giraY1(y4);
        x2=x_falsa;
        y2=y_falsa;
    }

    // ni idea que hace esto
    public int getMinXCoordinate(int x1, int x2, int x3, int x4) {
        return Math.min(Math.min(x1,x2),Math.min(x3,x4));
    }
}
