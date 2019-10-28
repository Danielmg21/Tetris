package com.example.tetris;

public class PiezaTroll extends Pieza {
    public int idColor;
    public int x1, y1;
    public int x2, y2;
    public int x3, y3;
    public int x4, y4;
    private Pieza pieza;
    public int pos;


    public PiezaTroll(int f, int a) {
        super(f, a);
        x1 = 2;
        y1 = 0 + a;
        x2 = 1;
        y2 = 1 + a;
        x3 = 3;
        y3 = 1 + a;
        x4 = 2;
        y4 = 2 + a;

        idColor = 8;
        pos = 0;
    }
}
