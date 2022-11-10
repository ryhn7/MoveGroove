package com.example.movegroove_musicapp;

import static com.example.movegroove_musicapp.MainActivity.musicFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    TextView song_name, artist_name, duration_played, duration_total;
    ImageView cover_art, nextBtn, prevBtn, backBtn, playBtn;
    SeekBar seekBar;
    int position = -1;
    static Uri uri;
    static MediaPlayer mediaPlayer;
    static ArrayList<MusicFiles> listSongs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initViews();
        getIntentMethod();
    }

    private void getIntentMethod() {
        position = getIntent().getIntExtra("position", -1);
        listSongs = musicFiles;
        if (listSongs != null) {
            playBtn.setImageResource(R.drawable.pause);
            uri = Uri.parse(listSongs.get(position).getPath());
        }
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
            mediaPlayer.start();
        }
        else {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
            mediaPlayer.start();
        }
    }

    private void initViews() {
        song_name = findViewById(R.id.tv_songTitle);
//        artist_name = findViewById(R.id.song_artist);
        duration_played = findViewById(R.id.tv_currentTime);
        duration_total = findViewById(R.id.tv_totalTime);
        cover_art = findViewById(R.id.iv_musicImg);
        nextBtn = findViewById(R.id.btn_next);
        prevBtn = findViewById(R.id.btn_prev);
        backBtn = findViewById(R.id.back_btn);
        playBtn = findViewById(R.id.btn_play);
        seekBar = findViewById(R.id.sb_seekBar);
    }
}