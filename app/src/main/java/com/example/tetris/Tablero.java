package com.example.tetris;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        if (tab[x][y] == 0) return Color.parseColor("#001c21");// azul oscuro fondo
        if (tab[x][y] == 1) return Color.parseColor("#f000ff"); //rosa
        if (tab[x][y] == 2) return Color.parseColor("#4deeea"); //azul claro
        if (tab[x][y] == 3) return Color.parseColor("#001eff"); //azul oscuro
        if (tab[x][y] == 4) return Color.parseColor("#74ee15"); //verde
        if (tab[x][y] == 5) return Color.parseColor("#FF8000"); //naranja
        if (tab[x][y] == 6) return Color.parseColor("#ffe700"); //amarillo
        if (tab[x][y] == 7) return Color.parseColor("#FF0000"); //rojo
        return -1;
    }

    public void elDestructor(int fila) {
        ponerFila0(fila);
        for (int y = fila; y >= 1; y--) {
            for (int x = 0; x < getAnchoTablero(); x++) {
                this.tab[x][y] = this.tab[x][y - 1];
            }
        }
    }

    public void ponerFila0(int y) {
        for (int x = 0; x < 10; x++) {
            tab[x][y] = 0;
        }
    }

    public List<Integer> detectarFilas() {
        int contador = 0;
        List<Integer> l = new ArrayList<>();
        for (int y = 19; y >= 0; y--) {
            contador = 0;
            for (int x = 0; x < getAnchoTablero(); x++) {
                if (tab[x][y] != 0) {
                    contador++;
                }
            }
            if (contador == 10) {
                l.add(y);
                elDestructor(y);
                y++;
            }
        }
        return l;
    }


    //todas las posiciones a 0 para Thanos
    public void limpiarTablero() {
        for (int i = 0; i < alturaTablero; i++) {
            for (int j = 0; j < anchuraTablero; j++) {
                tab[i][j] = 0;
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


    //crear en clase Piezas atributo entero colorCode


    public void ponerPieza(Pieza pieza) {
        tab[pieza.x1][pieza.y1] = pieza.idColor;
        tab[pieza.x2][pieza.y2] = pieza.idColor;
        tab[pieza.x3][pieza.y3] = pieza.idColor;
        tab[pieza.x4][pieza.y4] = pieza.idColor;
    }

    public void borrarPieza(Pieza pieza) {
        tab[pieza.x1][pieza.y1] = 0;
        tab[pieza.x2][pieza.y2] = 0;
        tab[pieza.x3][pieza.y3] = 0;
        tab[pieza.x4][pieza.y4] = 0;
    }


    public Pieza alfredoAux(Pieza pieza) {
        Pieza P = new Pieza(pieza.idColor);
        pieza.copiarPieza(P, pieza);
        alfredo(P);
        return P;
    }


    /*Este metodo por favor no lo toqueis ni borreis porque os crujo
    servira para hacer las rotaciones en un futuro no muy lejano
     */

    //añadir el cambio de la posicion de la pieza

    public void alfredo(Pieza p) {
        switch (p.idColor) {

            case 1:
                //Cuadrado uso salpicadura
                //No tuvo ningun efecto
                break;

            case 2:
                switch (p.pos) {
                    case 0:
                        p.x1 = p.x1 + 1;
                        p.y1 = p.y1 + 0;
                        p.x2 = p.x2 + 0;
                        p.y2 = p.y2 + 1;
                        p.x3 = p.x3 - 1;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 - 2;
                        p.y4 = p.y4 + 1;
                        break;

                    case 1:
                        p.x1 = p.x1 - 1;
                        p.y1 = p.y1 + 0;
                        p.x2 = p.x2 + 0;
                        p.y2 = p.y2 - 1;
                        p.x3 = p.x3 + 1;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 2;
                        p.y4 = p.y4 - 1;
                        break;
                }
                if (p.pos == 1) {
                    p.pos = 0;
                } else {
                    p.pos++;
                }

                break;

            case 3://
                switch (p.pos) {
                    case 0:
                        p.x1 = p.x1 + 0;
                        p.y1 = p.y1 + 0;
                        p.x2 = p.x2 + 1;
                        p.y2 = p.y2 - 1;
                        p.x3 = p.x3 + 2;
                        p.y3 = p.y3 - 2;
                        p.x4 = p.x4 + 3;
                        p.y4 = p.y4 - 3;
                        break;

                    case 1:
                        p.y1 = p.y1 + 0;
                        p.x1 = p.x1 + 0;
                        p.y2 = p.y2 + 1;
                        p.x2 = p.x2 - 1;
                        p.y3 = p.y3 + 2;
                        p.x3 = p.x3 - 2;
                        p.y4 = p.y4 + 3;
                        p.x4 = p.x4 - 3;
                        break;
                }
                if (p.pos == 1) {
                    p.pos = 0;
                } else {
                    p.pos++;
                }
                break;

            case 4:
                switch (p.pos) {

                    case 0:
                        p.x1 = p.x1 + 1;
                        p.y1 = p.y1 + 0;
                        p.x2 = p.x2 + 0;
                        p.y2 = p.y2 + 1;
                        p.x3 = p.x3 - 1;
                        p.y3 = p.y3 + 2;
                        p.x4 = p.x4 - 1;
                        p.y4 = p.y4 + 0;
                        break;

                    case 1:
                        p.x1 = p.x1 + 1;
                        p.y1 = p.y1 + 1;
                        p.x2 = p.x2 + 0;
                        p.y2 = p.y2 + 0;
                        p.x3 = p.x3 - 1;
                        p.y3 = p.y3 - 1;
                        p.x4 = p.x4 + 1;
                        p.y4 = p.y4 - 1;
                        break;

                    case 2:
                        p.x1 = p.x1 - 2;
                        p.y1 = p.y1 + 1;
                        p.x2 = p.x2 - 1;
                        p.y2 = p.y2 + 0;
                        p.x3 = p.x3 + 0;
                        p.y3 = p.y3 - 1;
                        p.x4 = p.x4 + 0;
                        p.y4 = p.y4 + 1;
                        break;

                    case 3:
                        p.x1 = p.x1 + 0;
                        p.y1 = p.y1 - 2;
                        p.x2 = p.x2 + 1;
                        p.y2 = p.y2 - 1;
                        p.x3 = p.x3 + 2;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 0;
                        p.y4 = p.y4 + 0;
                        break;


                }
                if (p.pos == 3) {
                    p.pos = 0;
                } else {
                    p.pos++;
                }
                break;

            case 5:
                switch (p.pos) {
                    case 0:
                        p.x1 = p.x1 + 0;
                        p.y1 = p.y1 + 1;
                        p.x2 = p.x2 - 1;
                        p.y2 = p.y2 + 2;
                        p.x3 = p.x3 - 1;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 0;
                        p.y4 = p.y4 - 1;
                        break;

                    case 1:
                        p.x1 = p.x1 + 0;
                        p.y1 = p.y1 - 1;
                        p.x2 = p.x2 + 1;
                        p.y2 = p.y2 - 2;
                        p.x3 = p.x3 + 1;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 0;
                        p.y4 = p.y4 + 1;
                        break;
                }
                if (p.pos == 1) {
                    p.pos = 0;
                } else {
                    p.pos++;
                }
                break;

            case 6:
                switch (p.pos) {
                    case 0:
                        p.x1 = p.x1 + 1;
                        p.y1 = p.y1 + 0;
                        p.x2 = p.x2 + 0;
                        p.y2 = p.y2 + 1;
                        p.x3 = p.x3 - 1;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 - 2;
                        p.y4 = p.y4 - 1;
                        break;

                    case 1:
                        p.x1 = p.x1 + 0;
                        p.y1 = p.y1 + 2;
                        p.x2 = p.x2 - 1;
                        p.y2 = p.y2 + 1;
                        p.x3 = p.x3 + 0;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 1;
                        p.y4 = p.y4 - 1;
                        break;

                    case 2:
                        p.x1 = p.x1 - 2;
                        p.y1 = p.y1 - 1;
                        p.x2 = p.x2 - 1;
                        p.y2 = p.y2 - 2;
                        p.x3 = p.x3 + 0;
                        p.y3 = p.y3 - 1;
                        p.x4 = p.x4 + 1;
                        p.y4 = p.y4 + 0;
                        break;

                    case 3:
                        p.x1 = p.x1 + 1;
                        p.y1 = p.y1 - 1;
                        p.x2 = p.x2 + 2;
                        p.y2 = p.y2 + 0;
                        p.x3 = p.x3 + 1;
                        p.y3 = p.y3 + 1;
                        p.x4 = p.x4 + 0;
                        p.y4 = p.y4 + 2;
                        break;

                }
                if (p.pos == 3) {
                    p.pos = 0;
                } else {
                    p.pos++;
                }
                break;

            case 7:
                switch (p.pos) {
                    case 0:
                        p.x1 = p.x1 + 2;
                        p.y1 = p.y1 + 1;
                        p.x2 = p.x2 + 1;
                        p.y2 = p.y2 + 2;
                        p.x3 = p.x3 + 1;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 0;
                        p.y4 = p.y4 - 1;
                        break;

                    case 1:
                        p.x1 = p.x1 - 1;
                        p.y1 = p.y1 + 1;
                        p.x2 = p.x2 - 2;
                        p.y2 = p.y2 + 0;
                        p.x3 = p.x3 + 0;
                        p.y3 = p.y3 + 0;
                        p.x4 = p.x4 + 1;
                        p.y4 = p.y4 - 1;
                        break;

                    case 2:
                        p.x1 = p.x1 - 1;
                        p.y1 = p.y1 + 0;
                        p.x2 = p.x2 + 0;
                        p.y2 = p.y2 - 1;
                        p.x3 = p.x3 + 0;
                        p.y3 = p.y3 + 1;
                        p.x4 = p.x4 + 1;
                        p.y4 = p.y4 + 2;
                        break;

                    case 3:
                        p.x1 = p.x1 + 0;
                        p.y1 = p.y1 - 2;
                        p.x2 = p.x2 + 1;
                        p.y2 = p.y2 - 1;
                        p.x3 = p.x3 - 1;
                        p.y3 = p.y3 - 1;
                        p.x4 = p.x4 - 2;
                        p.y4 = p.y4 + 0;
                        break;

                }
                if (p.pos == 3) {
                    p.pos = 0;
                } else {
                    p.pos++;
                }
                break;
        }
    }

    /*este metodo mueve la pieza despues de comprobarlo abajo,izquierda o derecha segun el char
    que le pasen, para ello usamos comprueba y el tipo de movimiento y en comprueba hay que
    comprobar que la PIEZA  no se salga del tablero y que no choque con otras.
    Puede salirse la matriz auxiiar de rangos pero nunca se puede salir la pieza
     */
    public void moverPiezas(Pieza pieza, char x) {
        switch (x) {
            case 'i':
                if (puedeMoverse(pieza, -1, 0, false)) {
                    borrarPieza(pieza);
                    pieza.mover(-1, 0);
                    ponerPieza(pieza);
                }
                break;
            case 'd':
                if (puedeMoverse(pieza, 1, 0, false)) {
                    borrarPieza(pieza);
                    pieza.mover(1, 0);
                    ponerPieza(pieza);
                }
                break;
            case 'a':
                if (puedeMoverse(pieza, 0, 1, false)) {
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
    /*public void rotaPiezas(Pieza p){
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

    public boolean puedeMoverse(Pieza pieza, int x, int y, boolean vengoDeRotar) {
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
                if (!vengoDeRotar) {
                    n++;
                }
            }
        }
        if (n == 4) {
            return true;
        }

        return false;
    }
    /*public boolean puedeRotar(Pieza pieza){
        Pieza piezaaux = alfredoAux(pieza);
        int n = 0;

        Point xy1 = new Point(piezaaux.x1, piezaaux.y1);
        Point xy2 = new Point(piezaaux.x2, piezaaux.y2);
        Point xy3 = new Point(piezaaux.x3, piezaaux.y3);
        Point xy4 = new Point(piezaaux.x4, piezaaux.y4);

        Point aux1 = new Point(piezaaux.x1 , pieza.y1 );
        Point aux2 = new Point(piezaaux.x2 , pieza.y2 );
        Point aux3 = new Point(piezaaux.x3 , pieza.y3 );
        Point aux4 = new Point(piezaaux.x4 , pieza.y4 );

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
    }*/

    /*
    public boolean compruebaFinJuego(Piezas spielStein) {
        if(compruebaAbajo(spielStein) == false && spielStein.getMinXCoordinate(
                spielStein.x1, spielStein.x2, spielStein.x3, spielStein.x4)<=1) {
            return true;
        }
        return false;
    }
    */
    public Tablero getTablero() {
        return this;
    }

    public int getAlturaTablero() {
        return this.alturaTablero;
    }

    public int getAnchoTablero() {
        return this.anchuraTablero;
    }

    public void comprobarRotar(Pieza p) {
        Pieza aux = new Pieza(p.idColor);
        aux.pos = p.pos;
        aux.x1 = p.x1;
        aux.y1 = p.y1;
        aux.x2 = p.x2;
        aux.y2 = p.y2;
        aux.x3 = p.x3;
        aux.y3 = p.y3;
        aux.x4 = p.x4;
        aux.y4 = p.y4;

        alfredo(aux);
        if (puedeMoverse(aux, 0, 0, true)) {
            alfredo(p);
        }
    }
}