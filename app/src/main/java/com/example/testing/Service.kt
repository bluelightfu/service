package com.example.testing

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.testing.Parameters.CHANNEL_ID

class Service: Service() {
    override fun onCreate() {
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Notification Testing")
                .setContentText("hello!")
                .setSmallIcon(R.drawable.notification_icon)
                .build()
        startForeground(1,notification)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}