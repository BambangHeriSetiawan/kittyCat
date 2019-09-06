package com.simx.kittycat.ui.profile

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simx.kittycat.helper.Pref

class ProfileVM (private var pref:Pref) : BaseObservable() {
    fun logout() {
        pref.clear()
    }

}