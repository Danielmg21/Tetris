package com.example.tetris;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;


public class AudioService {
    static final int DECREASE = 1, INCREASE = 2, START = 3, PAUSE = 4;
    Boolean shouldPause = false;
    MediaPlayer loop;

    private void increase(){
        loop.setVolume(0.2f, 0.2f);

    }
    public void decrease(){
        loop.setVolume(1.0f, 1.0f);
    }

    public void start(Context c){
        loop = MediaPlayer.create(c,R.raw.acdcbackinblack);
        loop.start();
        shouldPause = false;
    }
    public void pause(){
        shouldPause = true;
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if(shouldPause) {
                            loop.pause();
                        }
                    }
                }, 100);
    }
}
