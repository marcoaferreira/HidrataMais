package com.joselaine.hidratamais

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class NotificationWorker(val appContext: Context, workerParameters: WorkerParameters):
    Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        val notificationManager = appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "your_channel_id"
        val channelName = "Your Notification Channel"

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(appContext, channelId)
            .setSmallIcon(R.drawable.baseline_water_drop_24)
            .setContentTitle("Alerta de sede!")
            .setContentText("Abasteça sua garrafa.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notification = builder.build()
        val idNotification = Random.nextInt()

        notificationManager.notify(idNotification, notification)

        return Result.success()

    }

}