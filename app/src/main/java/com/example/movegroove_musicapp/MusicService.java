package com.example.movegroove_musicapp;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.ArrayList;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    private Runnable runnable;
    private AudioManager audioManager;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}