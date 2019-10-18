package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class VentanaNext extends View {
    private MainActivity mainActivity;
    private Tablero ventana;
    private Pieza pieza;
    private Timer timer;
    private int timerPeriod = 250;

    public VentanaNext(Context context, Tablero ventana, Pieza p) {
        super(context);
        this.mainActivity = (MainActivity) context;
        this.ventana = ventana;
    }

    public void runVentanaNext(Pieza p) {
        limpiarVentana();
        getPieza(p);
        ventana.ponerPieza(p);
    }

    public void limpiarVentana() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ventana.tab[i][j] = 0;
            }
        }
    }

    public Pieza getPieza(Pieza p) {

        switch (p.idColor) { // Cuadrado
            case 1:
                p.x1 = 1;
                p.y1 = 1;
                p.x2 = 2;
                p.y2 = 1;
                p.x3 = 1;
                p.y3 = 2;
                p.x4 = 2;
                p.y4 = 2;

                p.idColor = 1;
                p.pos = 0;
                break;

            case 2:    // Z Pieza
                p.x1 = 0;
                p.y1 = 1;
                p.x2 = 1;
                p.y2 = 1;
                p.x3 = 1;
                p.y3 = 2;
                p.x4 = 2;
                p.y4 = 2;

                p.idColor = 2;
                p.pos = 0;
                break;

            case 3: // I Pieza
                p.x1 = 1;
                p.y1 = 0;
                p.x2 = 1;
                p.y2 = 1;
                p.x3 = 1;
                p.y3 = 2;
                p.x4 = 1;
                p.y4 = 3;

                p.idColor = 3;
                p.pos = 0;
                break;

            case 4: // T Pieza
                p.x1 = 1;
                p.y1 = 1;
                p.x2 = 0;
                p.y2 = 2;
                p.x3 = 1;
                p.y3 = 2;
                p.x4 = 2;
                p.y4 = 2;

                p.idColor = 4;
                p.pos = 0;
                break;

            case 5: // S Pieza
                p.x1 = 1;
                p.y1 = 1;
                p.x2 = 2;
                p.y2 = 1;
                p.x3 = 0;
                p.y3 = 2;
                p.x4 = 1;
                p.y4 = 2;

                p.idColor = 5;
                p.pos = 0;
                break;

            case 6:  // J Pieza
                p.x1 = 2;
                p.y1 = 1;
                p.x2 = 2;
                p.y2 = 2;
                p.x3 = 1;
                p.y3 = 3;
                p.x4 = 2;
                p.y4 = 3;

                p.idColor = 6;
                p.pos = 0;
                break;

            case 7:  // L Pieza
                p.x1 = 1;
                p.y1 = 1;
                p.x2 = 1;
                p.y2 = 2;
                p.x3 = 1;
                p.y3 = 3;
                p.x4 = 2;
                p.y4 = 3;

                p.idColor = 7;
                p.pos = 0;
                break;
        }
        return pieza;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincel = new Paint();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                int color = ventana.parseaColor(x, y);
                pincel.setColor(color);
                canvas.drawRect(x * getMeasuredWidth() / 4, y * getMeasuredHeight() / 4, x * getMeasuredWidth() + getMeasuredWidth() / 4,
                        y * getMeasuredHeight() + getMeasuredHeight() / 4, pincel);
            }
        }

        //Pintamos el tablero front
        Paint pBorde = new Paint();
        pBorde.setStyle(Paint.Style.STROKE);
        pBorde.setColor(Color.BLACK);
        pBorde.setStrokeWidth(2);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                canvas.drawLine((x + 1) * getMeasuredWidth() / 4, 0, (x + 1) * getMeasuredWidth() / 4, getMeasuredHeight(), pBorde);
                canvas.drawLine(0, (y + 1) * getMeasuredHeight() / 4, getMeasuredWidth(), (y + 1) * getMeasuredHeight() / 4, pBorde);
            }
        }
    }
}
