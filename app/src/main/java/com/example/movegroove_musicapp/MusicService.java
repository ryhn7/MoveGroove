package com.example.movegroove_musicapp;

import static com.example.movegroove_musicapp.PlayerActivity.listSongs;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener {
    MusicBinder musicBinder = new MusicBinder();
    MediaPlayer mediaPlayer;
    Uri uri;
    int position = -1;
    ArrayList<MusicFiles> musicFiles = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MusicService", "onBind: ");
        return musicBinder;
    }


    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int myPosition = intent.getIntExtra("servicePosition", -1);
        if (myPosition != -1) {
            playMedia(myPosition);
        }
        return START_STICKY;
    }

    private void playMedia(int startPosition) {
        musicFiles = listSongs;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            if (musicFiles != null) {
                createMediaPlayer(startPosition);
                mediaPlayer.start();
            }
        } else {
            createMediaPlayer(startPosition);
            mediaPlayer.start();
        }

    }

    void start() {
        mediaPlayer.start();
    }

    boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    void stop() {
        mediaPlayer.stop();
    }

    void release() {
        mediaPlayer.release();
    }

    void pause() {
        mediaPlayer.pause();
    }

    int getDuration() {
        return mediaPlayer.getDuration();
    }

    void seekTo(int position) {
        mediaPlayer.seekTo(position);
    }

    int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    void createMediaPlayer(int position) {
        uri = Uri.parse(musicFiles.get(position).getPath());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
    }

    void onCompleted() {
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

}
