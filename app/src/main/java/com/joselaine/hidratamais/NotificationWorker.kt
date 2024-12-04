package com.joselaine.hidratamais

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(context: Context, workerParameters: WorkerParameters):
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        for ( i in 0 .. 1000){
            println("Realizando tarefa $i")
        }
        return Result.success()
    }

}