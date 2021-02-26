package com.example.sensorlib

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ServiceListener : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent != null && intent.action != null) {

            if (intent.action.equals(SensorService.KEY_NOTIFICATION_STOP_ACTION)) {
                context?.let {

                    val notificationManager =
                        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                    val locatyIntent = Intent(context, SensorService::class.java)

                    context.stopService(locatyIntent)
                    val notificationId = intent.getIntExtra(SensorService.KEY_NOTIFICATION_ID, -1)
                    if (notificationId != -1) {

                        notificationManager.cancel(notificationId)
                    }
                }
            }
        }
    }
}