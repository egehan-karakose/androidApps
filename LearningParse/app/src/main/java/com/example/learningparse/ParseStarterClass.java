package com.example.learningparse;

import android.app.Application;

import com.parse.Parse;


public class ParseStarterClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("K2OIxRSlb2RLDeDrMdjBw1M08jCvdD2xqdm0ecAY")
                .clientKey("UmgR71Qc9okLITBR3mxSIBqkgcHscpDzOifC4Hec")
                .server("https://parseapi.back4app.com/")
                .build()

        );



    }

}

