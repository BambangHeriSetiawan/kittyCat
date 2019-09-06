package com.simx.kittycat.helper

import android.annotation.SuppressLint
import android.content.Context

/**
 * Created by simx on 06,September,2019
 */


class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    var isLogin : Boolean
        get() = pref.getBoolean(KEY_IS_LOGIN, false)
        set(value) = pref.edit().putBoolean(KEY_IS_LOGIN,value).apply()

    @SuppressLint("ApplySharedPref")
    fun clear(){
        pref.edit().clear().commit()
    }

    companion object {
        const val PREF_NAME = "kitty"
        const val KEY_IS_LOGIN = "is_login"
    }

}