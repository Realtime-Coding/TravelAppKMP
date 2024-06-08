package com.travel.buddy

import android.app.Application
//import di.initKoin

class MuseumApp : Application() {

    companion object {
        lateinit var INSTANCE: MuseumApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        //initKoin()
    }
}
