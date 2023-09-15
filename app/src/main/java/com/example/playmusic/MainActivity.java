package com.example.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton bt;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.botao);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

        bt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                if(mediaPlayer == null){

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                }


                if(mediaPlayer.isPlaying()){


                    bt.setImageResource(R.drawable.music_off);
                    bt.setBackgroundResource(R.color.red);

                    mediaPlayer.release();
                    mediaPlayer = null;
                } else{

                    bt.setImageResource(R.drawable.music_on);
                    bt.setBackgroundResource(R.color.roxo);
                    mediaPlayer.start();
                }
            }
        });
    }
}