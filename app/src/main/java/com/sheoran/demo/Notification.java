package com.sheoran.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {
Button b1 ,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        b1 = findViewById(R.id.button2);
        b2 = findViewById( R.id.button3);

        b1.setOnClickListener(v -> {

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O)
            {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mchannel =new NotificationChannel("id","xyz",importance);
                mchannel.setDescription("channel one");
                mchannel.enableLights(true);
                mchannel.enableVibration(true);
                mchannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,100});
                mchannel.setShowBadge(false);
                nm.createNotificationChannel(mchannel);

            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "id");
            builder.setSmallIcon(R.drawable.ic_launcher_background);
            builder.setContentTitle("hello");
            builder.setContentText("welcome... how r u");
            builder.setAutoCancel(true);
            builder.setDefaults(NotificationCompat.DEFAULT_ALL);
            builder.setPriority(NotificationCompat.PRIORITY_HIGH);


            Intent intent = new Intent(this, MainActivity2.class);
            PendingIntent pi = PendingIntent.getActivity(this, 1, intent, 0);

            builder.setContentIntent(pi);

            nm.notify(13, builder.build());



        });
        b2.setOnClickListener(v -> {
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.cancel(13);
        });
    }
}