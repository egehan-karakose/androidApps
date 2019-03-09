package com.example.foursqarecloneparse

import android.app.Application
import com.parse.Parse

class StarterApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Parse.initialize(Parse.Configuration.Builder(this)
            .applicationId("r8nDIgMfjGG2gCAN47hWA8NPvlqS5pyrH2gPBtDq")
            .server("https://parseapi.back4app.com/")
            .clientKey("JHtvK8nsz7besVS4S3uICRnDWEOdIUALTpPnINnV")
            .build()


        )
    }
}