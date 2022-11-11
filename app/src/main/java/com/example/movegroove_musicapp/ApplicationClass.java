package com.example.movegroove_musicapp;

import android.app.Application;

public class ApplicationClass extends Application {
    public static final String CHANNEL_ID_1 = "channel1";
    public static final String CHANNEL_ID_2 = "channel2";
    public static final String ACTION_PREVIOUS = "actionPrevious";
    public static final String ACTION_NEXT = "actionNext";
    public static final String ACTION_PLAY = "actionPlay";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            android.app.NotificationChannel channel1 = new android.app.NotificationChannel(
                    CHANNEL_ID_1,
                    "Channel 1",
                    android.app.NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");

            android.app.NotificationChannel channel2 = new android.app.NotificationChannel(
                    CHANNEL_ID_2,
                    "Channel 2",
                    android.app.NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is Channel 2");

            android.app.NotificationManager manager = getSystemService(android.app.NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
