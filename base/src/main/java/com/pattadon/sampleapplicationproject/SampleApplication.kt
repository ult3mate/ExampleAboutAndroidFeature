package com.pattadon.sampleapplicationproject

import android.app.Application
import com.pattadon.sampleapplicationproject.manager.ContexterManager

/**
 * Created by pattadon on 8/18/17.
 */
class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ContexterManager.getInstance().applicationContext = this
    }
}