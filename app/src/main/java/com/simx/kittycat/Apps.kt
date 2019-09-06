package com.simx.kittycat

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * Created by simx on 06,September,2019
 */
class Apps: Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}