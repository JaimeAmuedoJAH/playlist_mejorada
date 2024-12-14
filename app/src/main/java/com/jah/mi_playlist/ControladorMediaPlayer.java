package com.jah.mi_playlist;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;

public class ControladorMediaPlayer {

    public static MediaPlayer mediaPlayer;
    static Runnable handlerTask;
    static Handler handler = new Handler();

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        ControladorMediaPlayer.mediaPlayer = mediaPlayer;
    }

    public static void stop(SeekBar sbBarra){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            sbBarra.setProgress(0);
            mediaPlayer = null;
        }
    }

    public static void pause(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public static void play(Cancion c, Context context, SeekBar sbBarra){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(context, c.getCancion());
            mediaPlayer.start();
        }else if(!mediaPlayer.isPlaying()){
           mediaPlayer.start();
        }else if(mediaPlayer.isPlaying() && mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(context, c.getCancion());
            mediaPlayer.start();
        }
        startTimer(sbBarra);
    }

    private static void startTimer(SeekBar sbBarra) {
        handlerTask = new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    int posicion = mediaPlayer.getCurrentPosition();
                    sbBarra.setMax(mediaPlayer.getDuration());
                    sbBarra.setProgress(posicion);
                }
                handler.postDelayed(handlerTask, 1000);
            }
        };
        handler.post(handlerTask);
    }

    public static void seekTo(int posicion){
        mediaPlayer.seekTo(posicion);
    }
}
