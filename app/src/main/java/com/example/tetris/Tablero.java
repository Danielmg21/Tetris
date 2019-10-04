package com.example.tetris;

import android.graphics.Color;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Tablero{

    private final int alturaTablero =20;
    private final int anchuraTablero=10;
    private int tablero[][]=new int[alturaTablero][anchuraTablero];
    private final Random random = new Random();
    private ArrayList<Pieces> listaPiecess = new ArrayList<Pieces>();
    private  final int numeroPiecess = 7;



    //genera dos Piecess random (1.actual, 2.siguiente)

    public Tablero() {
        listaPiecess.add(new Pieces(random.nextInt(numeroPiecess)+1));
        listaPiecess.add(new Pieces(random.nextInt(numeroPiecess)+1));
    }

     //transforma numeros de matriz a color

    public int parseaColor(int x, int y) {

        if(tablero[x][y]==0) return Color.parseColor("#00FFFF"); ; // I piece Cyan
        if(tablero[x][y]==1) return Color.parseColor("#0000FF"); ; // J piece Blue
        if(tablero[x][y]==2) return Color.parseColor("#FF0000"); ; // Z piece Red
        if(tablero[x][y]==3) return Color.parseColor("#ffbf00"); ; // L piece Orange
        if(tablero[x][y]==4) return Color.parseColor("#00FF00"); ; // S Green
        if(tablero[x][y]==5) return Color.parseColor("#FFFF00"); ; // cuadrado yellow
        if(tablero[x][y]==6) return Color.parseColor("#572364"); ; //  T piece Morado
        if(tablero[x][y]==7) return Color.parseColor("#BEBEBE");  // gris fondo


    }


    //todas las posiciones a 0
    public void limpiarTablero() {
        for(int i=0; i<alturaTablero; i++) {
            for(int j=0; j<anchuraTablero; j++) {
                tablero[i][j]= 0;
            }
        }
    }


    public  ArrayList<Pieces> getListaPiecess(){

        return listaPiecess;

    }

    //coge la Pieces actual
    public Pieces getPieces()  {

        return listaPiecess.get(listaPiecess.size() - 2);

    }

    //coge siguiente Pieces
    public Pieces getSiguientePieces() {

        return listaPiecess.get(listaPiecess.size()-1);

    }

    //crear en clase Pieces atributo entero colorCode

    private void colocaPieces(Pieces PiecesActual) {
        tablero[PiecesActual.x1][PiecesActual.y1] = PiecesActual.colorCode;
        tablero[PiecesActual.x2][PiecesActual.y2] = PiecesActual.colorCode;
        tablero[PiecesActual.x3][PiecesActual.y3] = PiecesActual.colorCode;
        tablero[PiecesActual.x4][PiecesActual.y4] = PiecesActual.colorCode;
    }

    //coordenadas Pieces = 0
    private void borraPieces(Pieces PiecesActual) {
        tablero[PiecesActual.x1][PiecesActual.y1] = 0;
        tablero[PiecesActual.x2][PiecesActual.y2] = 0;
        tablero[PiecesActual.x3][PiecesActual.y3] = 0;
        tablero[PiecesActual.x4][PiecesActual.y4] = 0;
    }


    //comprueba si la Pieces puede moverse,
    // copia la Pieces y la mueve, devuelve true si puede moverse

    private boolean checkMoverPieces(Pieces PiecesActual, int x, int y) {
        int tmp =0;
        /*
        copia las coordenadas
         */
        Point p1 = new Point(PiecesActual.x1, PiecesActual.y1);
        Point p2 = new Point(PiecesActual.x2, PiecesActual.y2);
        Point p3 = new Point(PiecesActual.x3, PiecesActual.y3);   //Pieces actual
        Point p4 = new Point(PiecesActual.x4, PiecesActual.y4);

        Point tmp1 = new Point(PiecesActual.x1+x, PiecesActual.y1+y);
        Point tmp2 = new Point(PiecesActual.x2+x, PiecesActual.y2+y);
        Point tmp3 = new Point(PiecesActual.x3+x, PiecesActual.y3+y);  //destino Pieces
        Point tmp4 = new Point(PiecesActual.x4+x, PiecesActual.y4+y);

        ArrayList<Point> tmpPieceCoordinates = new ArrayList<Point>();

        tmpPieceCoordinates.add(tmp1);
        tmpPieceCoordinates.add(tmp2);
        tmpPieceCoordinates.add(tmp3);
        tmpPieceCoordinates.add(tmp4);


        for(Point p : tmpPieceCoordinates ) {

            if(p.x< alturaTablero && p.y>=0 && p.y< anchuraTablero && tablero[p.x][p.y]==0) {
                tmp++;
            }

            else if(p.equals(p1) || p.equals(p2) || p.equals(p3) || p.equals(p4)) {
                tmp++;
            }
        }

        if(tmp==4) {
            return true;
        }
        return false;
    }

 /*
     copiar la Pieces actual y comprobar si puede rotar
     si puede devuelve true
      */

    private boolean rotarPieces(Pieces PiecesActual) {
        int tmp =0;
        ArrayList<Point> tmpPieceCoordinates = new ArrayList<Point>();

        Piece tmpStein = new Piece(currentPiece);

        Point p1 = new Point(PiecesActual.x1, PiecesActual.y1);
        Point p2 = new Point(PiecesActual.x2, PiecesActual.y2);
        Point p3 = new Point(PiecesActual.x3, PiecesActual.y3);
        Point p4 = new Point(PiecesActual.x4, PiecesActual.y4);

        tmpStein.turnPiece();

        Point tmp1 = new Point(tmpStein.x1, tmpStein.y1);
        Point tmp2 = new Point(tmpStein.x2, tmpStein.y2);
        Point tmp3 = new Point(tmpStein.x3, tmpStein.y3);
        Point tmp4 = new Point(tmpStein.x4, tmpStein.y4);

        tmpPieceCoordinates .add(tmp1);
        tmpPieceCoordinates .add(tmp2);
        tmpPieceCoordinates .add(tmp3);
        tmpPieceCoordinates .add(tmp4);

        for(Point p : tmpPieceCoordinates  ) {

            if(p.x< alturaTablero && p.x>=0 && p.y>=0 && p.y< anchuraTablero && tablero[p.x][p.y]==0) {
                tmp++;
            }

            else if(p.equals(p1) || p.equals(p2) || p.equals(p3) || p.equals(p4)) {
                tmp++;
            }
        }

        if(tmp==4) {  /* todas las coordenadas estan correctas*/
            return true;
        }
        return false;
    }


    //comprueba movimiento a la izq
    private  boolean checkIzq(Pieces PiecesActual) {
        if(piece_Can_Move(PiecesActual, 0, -1)==true) {
            return true;
        }
        return false;
    }

    //comprueba movimiento a la dcha
    private boolean checkDcha(Pieces PiecesActual){
        if(piece_Can_Move(PiecesActual, 0,1) == true) {
            return true;
        }
        return false;
    }

    //comprueba movimiento hacia abajo
    public boolean checkAbajo(Pieces PiecesActual) {
        if(piece_Can_Move(PiecesActual, 1,0)==true) {
            return true;
        }
        return false;
    }

    //realiza los movimientos

    private void moverPieces(Pieces PiecesActual, int x, int y)   {
        borraPieces(PiecesActual);
        PiecesActual.move(x, y);
        colocaPieces(PiecesActual);
    }

    public void moverDcha(Pieces PiecesActual){
        if(can_Move_Right(PiecesActual)==true) {
            moverPieces(PiecesActual, 0, 1);
        }
    }

    public  void moverIzq(Pieces PiecesActual){
        if(can_Move_Left(PiecesActual)==true) {
            moverPieces(PiecesActual, 0, -1);
        }
    }

    public  void moverAbajo(Pieces PiecesActual) {
        if(can_Move_Down(PiecesActual)==true) {
            moverPieces(PiecesActual, 1, 0);
        }
    }

    //borra la Pieces y la coloca los mas abajo que pueda
        public void fastDrop(Pieces PiecesActual) {
        borraPieces(PiecesActual);

        while(can_Move_Down(PiecesActual)==true) {
            moverAbajo(PiecesActual);
        }
        colocaPieces(PiecesActual);
    }

       /*
   gira todas las Piecess menos el cuadrado(colorCode=1
     */

    public void rotarPieces(Pieces PiecesActual) {

        if(piece_Can_Rotate(PiecesActual)==true && PiecesActual.colorCode!=1) {
            borraPieces(PiecesActual);
            PiecesActual.turnPiece();
            colocaPieces(PiecesActual);
        }
        colocaPieces(PiecesActual);
    }

    public int clearRows() {

        int deletedRowIndex;
        int deletedRows=0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < alturaTablero; i++) {
            for (int j = anchuraTablero - 1; j >= 0; j--) {

                if (tablero[i][j]==0) { // fila no esta completa
                    break;
                }
                if (j == 0) {
                    deletedRowIndex = i;
                    arrayList.add(deletedRowIndex);
                    deletedRows++;
                    deleteRow(deletedRowIndex);
                }
            }
        }

        if (deletedRows >= 1) {
            int highestRow = Collections.min(arrayList); // highest Row which can be cleared
            int[][] copiaTablero = new int[highestRow][anchuraTablero];

            for (int i = 0; i < copiaTablero.length; i++) {
                for (int j = 0; j < copiaTablero[1].length; j++) {
                    copiaTablero[i][j] = tablero[i][j];
                }
            }
            for (int i = 0; i < copiaTablero.length; i++) {
                for (int j = 0; j < copiaTablero[1].length; j++) {
                    tablero[i+deletedRows][j] = copiaTablero[i][j];
                }
            }
        }
        return deletedRows;
    }

    public void borraFila(int r){
        for (int i = 0; i < anchuraTablero; i++) {
            tablero[r][i] =0;
        }
    }

    public boolean compruebaFinJuego(Pieces spielStein) {
        if(can_Move_Down(spielStein) == false && spielStein.getMinXCoordinate(
                spielStein.x1, spielStein.x2, spielStein.x3, spielStein.x4)<=1) {
            return true;
        }
        return false;
    }

    public  int getAlturaTablero() {

        return this.alturaTablero;

    }

    public int getAnchoTablero() {

        return this.anchuraTablero;

    }
}