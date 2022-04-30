package com.example.notification7learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        switch (v.getId()) {
            case R.id.simpleNotificationBtn:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                Notification notification = new NotificationCompat.Builder(this, "myapp")
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("my notification")
                        .setContentText("this is my first notification")
                        .setContentIntent(pendingIntent)
                        .build();
                notificationManager.notify(new Random().nextInt(), notification);

                break;
            case R.id.bigpicturebtn:
                Notification bigPictureNotification = new NotificationCompat.Builder(this, "myapp")
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("my notification")
                        .setContentText("this is my first notification")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.eagle)).setBigContentTitle("BigPictureStyle"))
                        .build();
                notificationManager.notify(new Random().nextInt(), bigPictureNotification);

        }
    }

}