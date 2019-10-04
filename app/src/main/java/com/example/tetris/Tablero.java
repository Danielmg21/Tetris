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
    private ArrayList<Pieza> listaPiezas = new ArrayList<Pieza>();
    private  final int numeroPiezas = 7;



    //genera dos piezas random (1.actual, 2.siguiente)

    public Tablero() {
        listaPiezas.add(new Pieza(random.nextInt(numeroPiezas)+1));
        listaPiezas.add(new Pieza(random.nextInt(numeroPiezas)+1));
    }

     //transforma numeros de matriz a color

    public void parseaColor(int x, int y) {

        if(tablero[x][y]==0) return Color.parseColor("#FFFF00");  // Yellow
        if(tablero[x][y]==1) return Color.parseColor("#00FF00"); ; // Square Green
        if(tablero[x][y]==2) return Color.parseColor("#FF00FF"); ; //  Z piece Magenta
        if(tablero[x][y]==3) return Color.parseColor("#0000FF"); ; // I piece Blue
        if(tablero[x][y]==4) return Color.parseColor("#00FFFF"); ; // T piece Cyan
        if(tablero[x][y]==5) return Color.parseColor("#ffbf00"); ; // S piece Orange
        if(tablero[x][y]==6) return Color.parseColor("#BEBEBE"); ; // J piece gray
        if(tablero[x][y]==7) return Color.parseColor("#FF0000"); ; // L piece Red

    }


    //todas las posiciones a 0
    public void limpiarTablero() {
        for(int i=0; i<alturaTablero; i++) {
            for(int j=0; j<anchuraTablero; j++) {
                tablero[i][j]= 0;
            }
        }
    }


    public  ArrayList<Pieza> getListaPiezas(){

        return listaPiezas;

    }

    //coge la pieza actual
    public Pieza getPieza()  {

        return listaPiezas.get(listaPiezas.size() - 2);

    }

    //coge siguiente pieza
    public Pieza getSiguientePieza() {

        return listaPiezas.get(listaPiezas.size()-1);

    }

    //crear en clase pieza atributo entero colorCode

    private void colocaPieza(Pieza piezaActual) {
        tablero[piezaActual.x1][piezaActual.y1] = piezaActual.colorCode;
        tablero[piezaActual.x2][piezaActual.y2] = piezaActual.colorCode;
        tablero[piezaActual.x3][piezaActual.y3] = piezaActual.colorCode;
        tablero[piezaActual.x4][piezaActual.y4] = piezaActual.colorCode;
    }

    //coordenadas pieza = 0
    private void borraPieza(Pieza piezaActual) {
        tablero[piezaActual.x1][piezaActual.y1] = 0;
        tablero[piezaActual.x2][piezaActual.y2] = 0;
        tablero[piezaActual.x3][piezaActual.y3] = 0;
        tablero[piezaActual.x4][piezaActual.y4] = 0;
    }


    //comprueba si la pieza puede moverse,
    // copia la pieza y la mueve, devuelve true si puede moverse

    private boolean checkMoverPieza(Pieza piezaActual, int x, int y) {
        int tmp =0;
        /*
        copia las coordenadas
         */
        Point p1 = new Point(piezaActual.x1, piezaActual.y1);
        Point p2 = new Point(piezaActual.x2, piezaActual.y2);
        Point p3 = new Point(piezaActual.x3, piezaActual.y3);   //pieza actual
        Point p4 = new Point(piezaActual.x4, piezaActual.y4);

        Point tmp1 = new Point(piezaActual.x1+x, piezaActual.y1+y);
        Point tmp2 = new Point(piezaActual.x2+x, piezaActual.y2+y);
        Point tmp3 = new Point(piezaActual.x3+x, piezaActual.y3+y);  //destino pieza
        Point tmp4 = new Point(piezaActual.x4+x, piezaActual.y4+y);

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
     copiar la pieza actual y comprobar si puede rotar
     si puede devuelve true
      */

    private boolean rotarPieza(Pieza piezaActual) {
        int tmp =0;
        ArrayList<Point> tmpPieceCoordinates = new ArrayList<Point>();

        Piece tmpStein = new Piece(currentPiece);

        Point p1 = new Point(piezaActual.x1, piezaActual.y1);
        Point p2 = new Point(piezaActual.x2, piezaActual.y2);
        Point p3 = new Point(piezaActual.x3, piezaActual.y3);
        Point p4 = new Point(piezaActual.x4, piezaActual.y4);

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
    private  boolean checkIzq(Pieza piezaActual) {
        if(piece_Can_Move(piezaActual, 0, -1)==true) {
            return true;
        }
        return false;
    }

    //comprueba movimiento a la dcha
    private boolean checkDcha(Pieza piezaActual){
        if(piece_Can_Move(piezaActual, 0,1) == true) {
            return true;
        }
        return false;
    }

    //comprueba movimiento hacia abajo
    public boolean checkAbajo(Pieza piezaActual) {
        if(piece_Can_Move(piezaActual, 1,0)==true) {
            return true;
        }
        return false;
    }

    //realiza los movimientos

    private void moverPieza(Pieza piezaActual, int x, int y)   {
        borraPieza(piezaActual);
        piezaActual.move(x, y);
        colocaPieza(piezaActual);
    }

    public void moverDcha(Pieza piezaActual){
        if(can_Move_Right(piezaActual)==true) {
            moverPieza(piezaActual, 0, 1);
        }
    }

    public  void moverIzq(Pieza piezaActual){
        if(can_Move_Left(piezaActual)==true) {
            moverPieza(piezaActual, 0, -1);
        }
    }

    public  void moverAbajo(Pieza piezaActual) {
        if(can_Move_Down(piezaActual)==true) {
            moverPieza(piezaActual, 1, 0);
        }
    }

    //borra la pieza y la coloca los mas abajo que pueda
        public void fastDrop(Pieza piezaActual) {
        borraPieza(piezaActual);

        while(can_Move_Down(piezaActual)==true) {
            moverAbajo(piezaActual);
        }
        colocaPieza(piezaActual);
    }

       /*
   gira todas las piezas menos el cuadrado(colorCode=1
     */

    public void rotarPieza(Pieza piezaActual) {

        if(piece_Can_Rotate(piezaActual)==true && piezaActual.colorCode!=1) {
            borraPieza(piezaActual);
            piezaActual.turnPiece();
            colocaPieza(piezaActual);
        }
        colocaPieza(piezaActual);
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

    public boolean compruebaFinJuego(Pieza spielStein) {
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