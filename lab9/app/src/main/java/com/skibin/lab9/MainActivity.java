package com.skibin.lab9;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNotifyWithButtons, btnNotifyWithLongText, btnNotifyWithPicture, btnNotifyInbox;
    private static final int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotifyWithButtons = findViewById(R.id.btnNotifyWithButtons);
        btnNotifyWithButtons.setOnClickListener(this);
        btnNotifyWithLongText = findViewById(R.id.btnNotifyWithLongText);
        btnNotifyWithLongText.setOnClickListener(this);
        btnNotifyWithPicture = findViewById(R.id.btnNotifyWithPicture);
        btnNotifyWithPicture.setOnClickListener(this);
        btnNotifyInbox = findViewById(R.id.btnNotifyInbox);
        btnNotifyInbox.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNotifyWithButtons:
                sendActionNotification();
                break;
            case R.id.btnNotifyWithLongText:
                sendBigTextNotification();
                break;
            case R.id.btnNotifyWithPicture:
                sendBigPictureNotification();
                break;
            case R.id.btnNotifyInbox:
                sendInboxNotification();
                break;
        }
    }

    void sendActionNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Посылка")
                .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.drawable.smallcat).setContentIntent(pIntent)
                .addAction(R.drawable.smallcat, "Открыть", pIntent)
                .addAction(R.drawable.smallcat, "Отказаться", pIntent)
                .addAction(R.drawable.smallcat, "Другой вариант", pIntent)
                .build();
        builder.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, builder);
    }

    void sendBigTextNotification() {
        String bigText = "Это я, почтальон Печкин. Принес для вас посылку. "
                + "Только я вам ее не отдам. Потому что у вас документов нету.";
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Уведомление с большим текстом")
                .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.drawable.smallcat)
                .addAction(R.drawable.smallcat, "Запустить активность", pIntent).setAutoCancel(true);
        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(bigText).build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    void sendBigPictureNotification() {
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Большая посылка")
                .setTicker("Пришла посылка")
                .setContentText("Уведомление с большой картинкой")
                .setSmallIcon(R.drawable.smallcat)
                .addAction(R.drawable.smallcat, "Запустить активность", pIntent);
        Notification notification = new Notification.BigPictureStyle(builder)
                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.bigcat)).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }

    void sendInboxNotification() {
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Уведомление в стиле Inbox")
                .setContentText("Inbox Style notification!!")
                .setSmallIcon(R.drawable.smallcat)
                .addAction(R.drawable.smallcat, "Запустить активность", pIntent);

        Notification notification = new Notification.InboxStyle(builder)
                .addLine("Первое сообщение").addLine("Второе сообщение")
                .addLine("Третье сообщение").addLine("Четвертое сообщение")
                .setSummaryText("+2 more").build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(3, notification);
    }

    void showExampleNotification() {
        Context context = getApplicationContext();
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                                                                PendingIntent.FLAG_CANCEL_CURRENT);
        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.smallcat)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.bigcat))
                .setTicker("Последнее китайской предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота");

        Notification notification = builder.getNotification();
        //Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }
}
