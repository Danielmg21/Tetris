package com.example.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class VentanaNext extends View {
    private MainActivity mainActivity;
    private Tablero ventana;
    private Juego juego;
    private Pieza pieza;
    public VentanaNext(Context context, Tablero ventana, Juego juego) {
        super(context);
        this.mainActivity = (MainActivity) context;
        this.ventana = ventana;
        this.juego = juego;

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
