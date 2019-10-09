package com.example.tetris;

public class Pieza {
    public int x, y;
    public Tablero[][] tab = new Tablero[5][5];
    public boolean canRotate;

    Pieza() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                tab[i][j] = new Tablero();
            }
        }
        x = y = 0;
        canRotate = true;
    }

    Pieza(int[][] _tab, int _color) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (_tab[i][j] == 1) {
                    tab[i][j] = new Tablero(_tab[i][j], _color);
                } else {
                    tab[i][j] = new Tablero();
                }
            }
        }
        x = y = 0;
        canRotate = true;
    }

    Pieza(int[][] _tab, int _color, final int behavior) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (_tab[i][j] == 1)
                    tab[i][j] = new Tablero(_tab[i][j], _color, behavior);
                else
                    tab[i][j] = new Tablero();

            }
        }
        canRotate = true;
    }

    Pieza(int[][] _tab, int _color, final int behavior, boolean _canRotate) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (_tab[i][j] == 1)
                    tab[i][j] = new Tablero(_tab[i][j], _color, behavior);
                else
                    tab[i][j] = new Tablero();

            }
        }
        canRotate = _canRotate;
    }

    Pieza(int[][] _tab, int _color, int _x, int _y) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (_tab[i][j] == 1) {
                    tab[i][j] = new Tablero(_tab[i][j], _color);
                } else {
                    tab[i][j] = new Tablero();
                }
            }
        }
        x = _x;
        y = _y;
        canRotate = true;
    }


    void RotateLeft() {
        if (!this.canRotate) {
            return;
        }

        Tablero[][] aux = new Tablero[5][5];
        for (int i = 1; i < 5; ++i) {
            for (int j = 1; j < 5; ++j) {
                aux[4 - j + 1][i] = tab[i][j];
            }
        }
        for (int i = 1; i < 5; ++i) {
            for (int j = 1; j < 5; ++j) {
                tab[i][j] = aux[i][j];
            }
        }
    }

    void RotateRight() {
        if (!this.canRotate) {
            return;
        }

        Tablero[][] aux = new Tablero[5][5];
        for (int i = 1; i < 5; ++i) {
            for (int j = 1; j < 5; ++j) {
                aux[j][4 - i + 1] = tab[i][j];
            }
        }
        for (int i = 1; i < 5; ++i) {
            for (int j = 1; j < 5; ++j) {
                tab[i][j] = aux[i][j];
            }
        }
    }
}