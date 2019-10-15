package com.example.tetris;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Tablero {

    private final int alturaTablero = 20;
    private final int anchuraTablero = 10;
    public int tab[][] = new int[anchuraTablero][alturaTablero];
    private final Random random = new Random();
    public ArrayList<Pieza> listaPiezas = new ArrayList<Pieza>();
    private final int numeroPiezas = 7;

    public Tablero() {
        listaPiezas.add(new Pieza(random.nextInt(numeroPiezas) + 1));
        listaPiezas.add(new Pieza(random.nextInt(numeroPiezas) + 1));
    }

    public void generarPieza() {
        listaPiezas.add(new Pieza(random.nextInt(numeroPiezas) + 1));
    }

    public void borrarPieza() {
        listaPiezas.remove(0);
    }
    //transforma numeros de matriz a color

    public int parseaColor(int x, int y) {
        if (tab[x][y] == 0) return Color.parseColor("#BEBEBE");// gris fondo
        if (tab[x][y] == 1) return Color.parseColor("#0000FF");
        if (tab[x][y] == 2) return Color.parseColor("#FF0000");
        if (tab[x][y] == 3) return Color.parseColor("#ffbf00");
        if (tab[x][y] == 4) return Color.parseColor("#00FF00");
        if (tab[x][y] == 5) return Color.parseColor("#FFFF00");
        if (tab[x][y] == 6) return Color.parseColor("#572364");
        if (tab[x][y] == 7) return Color.parseColor("#000000");
        return -1;
    }

    public void bajarFila(int y) {
        int x;
        int filaVacio = 0;
        boolean vacio = false;
        while ((y != 20) && (!vacio)) {
            for (x = 0; x < 10; x++) {
                this.tab[x][y] = this.tab[x][y + 1];
                if (this.tab[x][y + 1] == 7) {
                    filaVacio++;
                }
            }
            y++;
            if (filaVacio == 10) {
                vacio = true;
            }
            filaVacio = 0;
        }
    }

    //todas las posiciones a 7
    public void limpiarTablero() {
        for (int i = 0; i < alturaTablero; i++) {
            for (int j = 0; j < anchuraTablero; j++) {
                tab[i][j] = 7;
            }
        }
    }

    public ArrayList<Pieza> getListaPiezas() {
        return listaPiezas;
    }

    //coge la Piezas actual
    public Pieza getPieza() {
        return listaPiezas.get(0);
    }

    //coge siguiente Piezas
    public Pieza getSiguientePieza() {
        return listaPiezas.get(listaPiezas.size() - 1);
    }

    //crear en clase Piezas atributo entero colorCode


    public void ponerPieza(Pieza pieza) {
        tab[pieza.x1][pieza.y1] = pieza.idColor;
        tab[pieza.x2][pieza.y2] = pieza.idColor;
        tab[pieza.x3][pieza.y3] = pieza.idColor;
        tab[pieza.x4][pieza.y4] = pieza.idColor;
    }

    private void borrarPieza(Pieza pieza) {
        tab[pieza.x1][pieza.y1] = 0;
        tab[pieza.x2][pieza.y2] = 0;
        tab[pieza.x3][pieza.y3] = 0;
        tab[pieza.x4][pieza.y4] = 0;
    }

    /*este metodo mueve la pieza despues de comprobarlo abajo,izquierda o derecha segun el char
    que le pasen, para ello usamos comprueba y el tipo de movimiento y en comprueba hay que
    comprobar que la PIEZA  no se salga del tablero y que no choque con otras.
    Puede salirse la matriz auxiiar de rangos pero nunca se puede salir la pieza
     */
    public void moverPiezas(Pieza pieza, char x) {
        switch (x) {
            case 'i':
                if (puedeMoverse(pieza, -1, 0)) {
                    borrarPieza(pieza);
                    pieza.mover(-1, 0);
                    ponerPieza(pieza);
                }
                break;
            case 'd':
                if (puedeMoverse(pieza, 1, 0)) {
                    borrarPieza(pieza);
                    pieza.mover(1, 0);
                    ponerPieza(pieza);
                }
                break;
            case 'a':
                if (puedeMoverse(pieza, 0, 1)) {
                    borrarPieza(pieza);
                    pieza.mover(0, 1);
                    ponerPieza(pieza);
                }
                break;
        }

    }
    //las x anteriores son las y siguientes
    //las y anteriores son las x siguientes
    /*falta tocar el tema de borrar la pieza y ponerla con las nuevas posiciones
    y crear el puede rotar
     */
    /*public void RotaPiezas(Pieza p){
        int aux1;int aux2;
        aux1=p.y1;
        aux2=p.x1;
        p.x1=aux1;
        p.y1=aux2;

        aux1=p.y2;
        aux2=p.x2;
        p.x2=aux1;
        p.y2=aux2;

        aux1=p.y3;
        aux2=p.x3;
        p.x3=aux1;
        p.y3=aux2;

        aux1=p.y4;
        aux2=p.x4;
        p.x4=aux1;
        p.y4=aux2;
    }*/

    public boolean puedeMoverse(Pieza pieza, int x, int y) {
        int n = 0; //contador para saber si la pieza entera puede moverse
        Point xy1 = new Point(pieza.x1, pieza.y1);
        Point xy2 = new Point(pieza.x2, pieza.y2);
        Point xy3 = new Point(pieza.x3, pieza.y3);
        Point xy4 = new Point(pieza.x4, pieza.y4);

        Point aux1 = new Point(pieza.x1 + x, pieza.y1 + y);
        Point aux2 = new Point(pieza.x2 + x, pieza.y2 + y);
        Point aux3 = new Point(pieza.x3 + x, pieza.y3 + y);
        Point aux4 = new Point(pieza.x4 + x, pieza.y4 + y);

        //Creamos un array con los puntos posibles donde se puede mover
        ArrayList<Point> puntos = new ArrayList<Point>();
        puntos.add(aux1);
        puntos.add(aux2);
        puntos.add(aux3);
        puntos.add(aux4);

        //Recorremos el array de los posibles puntos y controlamos que estamos dentro del tablero o si está ocupada la posicion o no
        for (Point a : puntos) {
            if (a.x < anchuraTablero && a.x >= 0 && a.y >= 0 && a.y < alturaTablero && tab[a.x][a.y] == 0) {
                n++;
            } else if (a.equals(xy1) || a.equals(xy2) || a.equals(xy3) || a.equals(xy4)) {
                n++;
            }
        }
        if (n == 4) {
            return true;
        }

        return false;
    }

    /*
    public boolean compruebaFinJuego(Piezas spielStein) {
        if(compruebaAbajo(spielStein) == false && spielStein.getMinXCoordinate(
                spielStein.x1, spielStein.x2, spielStein.x3, spielStein.x4)<=1) {
            return true;
        }
        return false;
    }
    */
    public int getAlturaTablero() {
        return this.alturaTablero;
    }

    public int getAnchoTablero() {
        return this.anchuraTablero;
    }
}