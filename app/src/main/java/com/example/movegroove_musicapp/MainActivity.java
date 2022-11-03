package com.example.movegroove_musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button play, prev, next;
    TextView songTitle;
    SeekBar mSeekBarTime;
    MediaPlayer mMediaPlayer;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
        play = findViewById(R.id.btn_play);
        prev = findViewById(R.id.btn_prev);
        next = findViewById(R.id.btn_next);
        mSeekBarTime = findViewById(R.id.sb_seekBar);

        // array to store the song
        final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0,R.raw.idn1 );
        songs.add(1,R.raw.idn3 );

        // intializing mediaplayer
        mMediaPlayer = MediaPlayer.create(getApplicationContext(),
                songs.get(currentIndex));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if(mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                } else {
                    mMediaPlayer.start();
                }
            }
        });


    }
}