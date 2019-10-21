package com.example.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class QQlogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqlogin);
        String inten_exture_data = getIntent().getStringExtra("inten exture data");
        Toast.makeText(this,inten_exture_data,Toast.LENGTH_LONG).show();
        createNotificationChannel();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("feedback data","this is feedback data");
        setResult(2,intent);
        finish();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "test name";
            String description = "for test notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("test channel id", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void notifys(View view){

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        boolean isEnabled = notificationManager.areNotificationsEnabled();
        Intent intent = new Intent(this, Second.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "test channel id")
                .setSmallIcon(R.drawable.qmui_icon_notify_done)
                .setContentTitle("this is title demo")
                .setContentText("this is title content")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);


// notificationId is a unique int for each notification that you must define
        notificationManager.notify(23, builder.build());
    }
}
