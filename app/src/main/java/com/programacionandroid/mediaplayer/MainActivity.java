package com.programacionandroid.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer objMediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objMediaplayer = null;
    }

    public void reproducirMusica(View view){
        switch (view.getId()){
            //Boton Play
            case R.id.btnPlay:
                if(objMediaplayer == null){
                    objMediaplayer = MediaPlayer.create(this, R.raw.music);
                }
                objMediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopMusic();
                    }
                });
                objMediaplayer.start();
                break;
            //Boton Pause
            case R.id.btnPause:
                if(objMediaplayer != null){
                    objMediaplayer.pause();
                }
                break;
            //Boton Stop
            case R.id.btnStop:
                if(objMediaplayer != null){
                    objMediaplayer.stop();
                    stopMusic();;
                }
                break;
        }
    }

    private void stopMusic(){
        objMediaplayer.release();
        objMediaplayer = null;
    }

}