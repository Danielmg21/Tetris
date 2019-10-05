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
    private ArrayList<Piezas> listaPiezas = new ArrayList<Piezas>();
    private  final int numeroPiezas = 7;



    //genera dos Piezas random (1.actual, 2.siguiente)

    public Tablero() {
        listaPiezas.add(new Piezas(random.nextInt(numeroPiezas)+1));
        listaPiezas.add(new Piezas(random.nextInt(numeroPiezas)+1));
    }

     //transforma numeros de matriz a color

    public int parseaColor(int x, int y) {
        if(tablero[x][y]==0)  Color.parseColor("#00FFFF"); ; // I piece Cyan
        if(tablero[x][y]==1)  Color.parseColor("#0000FF"); ; // J piece Blue
        if(tablero[x][y]==2)  Color.parseColor("#FF0000"); ; // Z piece Red
        if(tablero[x][y]==3)  Color.parseColor("#ffbf00"); ; // L piece Orange
        if(tablero[x][y]==4)  Color.parseColor("#00FF00"); ; // S Green
        if(tablero[x][y]==5)  Color.parseColor("#FFFF00"); ; // cuadrado yellow
        if(tablero[x][y]==6)  Color.parseColor("#572364"); ; //  T piece Morado
        if(tablero[x][y]==7)  Color.parseColor("#BEBEBE");  // gris fondo
        return -1;
    }

    //todas las posiciones a 7
    public void limpiarTablero() {
        for(int i=0; i<alturaTablero; i++) {
            for(int j=0; j<anchuraTablero; j++) {
                tablero[i][j]= 7;
            }
        }
    }

    public  ArrayList<Piezas> getListaPiezas(){
        return listaPiezas;
    }

    //coge la Piezas actual
    public Piezas getPieza()  {
        return listaPiezas.get(listaPiezas.size() - 2);
    }

    //coge siguiente Piezas
    public Piezas getSiguientePieza() {
        return listaPiezas.get(listaPiezas.size()-1);
    }

    //crear en clase Piezas atributo entero colorCode

    private void colocaPieza(Piezas piezasActual) {
        //tablero[piezasActual.x1][piezasActual.y1] = piezasActual.identificador;
        //tablero[piezasActual.x2][piezasActual.y2] = piezasActual.identificador;
        //tablero[piezasActual.x3][piezasActual.y3] = piezasActual.identificador;
        //tablero[piezasActual.x4][piezasActual.y4] = piezasActual.identificador;
        piezasActual.coor.setValX(4);
        piezasActual.coor.setValY(20);

    }
    /*este metodo mueve la pieza despues de comprobarlo abajo,izquierda o derecha segun el char
    que le pasen, para ello usamos comprueba y el tipo de movimiento y en comprueba hay que
    comprobar que la PIEZA  no se salga del tablero y que no choque con otras.
    Puede salirse la matriz auxiiar de rangos pero nunca se puede salir la pieza
     */
    private void moverPiezas(Piezas piezasActual, char x ){
        switch (x){
            case 'i':
                if (compruebaIzq(piezasActual)){
                    piezasActual.coor.setValX(piezasActual.coor.getValX()-1);
                }
                break;
            case 'd':
                if (compruebaDcha(piezasActual)){
                    piezasActual.coor.setValX(piezasActual.coor.getValX()+1);
                }
                break;
            case 'a':
                if (compruebaAbajo(piezasActual)){
                    piezasActual.coor.setValY(piezasActual.coor.getValY()-1);
                }
                break;
        }

    }

    //movimiento piezas mediante matriz auxiliar
    //usar referencia de clase piezas para obtener movimiento de todas

    //comprueba si la Piezas puede moverse,
    // copia la Piezas y la mueve, devuelve true si puede moverse

    /*private boolean compruebaMovimientoPieza(Piezas piezasActual, int x, int y) {
        int tmp =0;

        copia las coordenadas

        Point p1 = new Point(piezasActual.x1, piezasActual.y1);
        Point p2 = new Point(piezasActual.x2, piezasActual.y2);
        Point p3 = new Point(piezasActual.x3, piezasActual.y3);   //Piezas actual
        Point p4 = new Point(piezasActual.x4, piezasActual.y4);

        Point tmp1 = new Point(piezasActual.x1+x, piezasActual.y1+y);
        Point tmp2 = new Point(piezasActual.x2+x, piezasActual.y2+y);
        Point tmp3 = new Point(piezasActual.x3+x, piezasActual.y3+y);  //destino Piezas
        Point tmp4 = new Point(piezasActual.x4+x, piezasActual.y4+y);

        ArrayList<Point> tmpPiezaCoordenadas = new ArrayList<Point>();

        tmpPiezaCoordenadas.add(tmp1);
        tmpPiezaCoordenadas.add(tmp2);
        tmpPiezaCoordenadas.add(tmp3);
        tmpPiezaCoordenadas.add(tmp4);


        for(Point p : tmpPiezaCoordenadas ) {

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
    }*/

 /*
     copiar la Piezas actual y comprobar si puede rotar
     si puede devuelve true
      */
    /*
    private boolean rotarPieces(Piezas PiecesActual) {
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

        if(tmp==4) {  /* todas las coordenadas estan correctas
            return true;
        }
        return false;
    }
    */
    /*estas tres comprobaciones comprueban si no toca limites del tablero la pieza y si no toca
    otras piezas, la unica excepcion es la que baja porque en el momento que choque ya no se podra
    mover mas y ya se cambiara de pieza
     */
    //comprueba movimiento a la izq
    private  boolean compruebaIzq(Piezas piezasActual) {
        ArrayList<Coordenada> l;
        l = piezasActual.ObtenerPosiciones(piezasActual);
        boolean problema = false;
        int posyahellegado=0;
        while (problema==false)  {
            if (posyahellegado==4) {
                return true;
            }
            else{
                Coordenada aux = l.get(posyahellegado);
                if((aux.getValX()==0)||(this.tablero[aux.getValX()-1][aux.getValY()]!=7)){
                    return false;
                }
                else{
                    posyahellegado++;
                }
            }
        }return true;
    }

    //comprueba movimiento a la dcha
    private  boolean compruebaDcha(Piezas piezasActual) {
        ArrayList<Coordenada> l;
        l = piezasActual.ObtenerPosiciones(piezasActual);
        boolean problema = false;
        int posyahellegado=0;
        while (problema==false)  {
            if (posyahellegado==4) {
                return true;
            }
            else{
                Coordenada aux = l.get(posyahellegado);
                if((aux.getValX()==10)||(this.tablero[aux.getValX()+1][aux.getValY()]!=7)){
                    return false;
                }
                else{
                    posyahellegado++;
                }
            }
        }return true;
    }

    //comprueba movimiento hacia abajo
    private  boolean compruebaAbajo(Piezas piezasActual) {
        ArrayList<Coordenada> l;
        l = piezasActual.ObtenerPosiciones(piezasActual);
        boolean problema = false;
        int posyahellegado=0;
        while (problema==false)  {
            if (posyahellegado==4) {
                return true;
            }
            else{
                Coordenada aux = l.get(posyahellegado);
                if((aux.getValY()==0)||(this.tablero[aux.getValX()][aux.getValY()-1]!=7)){
                    return false;
                }
                else{
                    posyahellegado++;
                }
            }
        }return true;
    }

    //realiza los movimientos

    private void moverPieza(Piezas piezasActual, int x, int y)   {
        borraPieza(piezasActual);
        piezasActual.move(x, y);
        colocaPieza(piezasActual);
    }



    //borra la Piezas y la coloca los mas abajo que pueda
        public void caidaRapida(Piezas piezasActual) {
        borraPieza(piezasActual);

        while(puede_Moverse_Abajo(piezasActual)==true) {
            moverAbajo(piezasActual);
        }
        colocaPieza(piezasActual);
    }

       /*
   gira todas las Piezas menos el cuadrado(colorCode=1
     */

    public void rotarPieza(Piezas piezasActual) {

        if(pieza_Puede_Rotar(piezasActual)==true && piezasActual.colorCode!=1) {
            borraPieza(piezasActual);
            piezasActual.girarPieza();
            colocaPieza(piezasActual);
        }
        colocaPieza(piezasActual);
    }

    public int clearRows() {

        int borrarFilaIndice;
        int borrarFilas=0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < alturaTablero; i++) {
            for (int j = anchuraTablero - 1; j >= 0; j--) {

                if (tablero[i][j]==0) { // fila no esta completa
                    break;
                }
                if (j == 0) {
                    borrarFilaIndice = i;
                    arrayList.add(borrarFilaIndice);
                    borrarFilas++;
                    borrarFila(borrarFilaIndice);
                }
            }
        }

        if (borrarFilas >= 1) {
            int highestRow = Collections.min(arrayList); // highest Row which can be cleared
            int[][] copiaTablero = new int[highestRow][anchuraTablero];

            for (int i = 0; i < copiaTablero.length; i++) {
                for (int j = 0; j < copiaTablero[1].length; j++) {
                    copiaTablero[i][j] = tablero[i][j];
                }
            }
            for (int i = 0; i < copiaTablero.length; i++) {
                for (int j = 0; j < copiaTablero[1].length; j++) {
                    tablero[i+borrarFilas][j] = copiaTablero[i][j];
                }
            }
        }
        return borrarFilas;
    }

    public void borraFila(int r){
        for (int i = 0; i < anchuraTablero; i++) {
            tablero[r][i] =0;
        }
    }

    public boolean compruebaFinJuego(Piezas spielStein) {
        if(puede_Moverse_Abajo(spielStein) == false && spielStein.getMinXCoordinate(
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