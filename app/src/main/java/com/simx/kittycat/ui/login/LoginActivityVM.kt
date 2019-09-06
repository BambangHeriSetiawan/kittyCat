package com.simx.kittycat.ui.login


import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.simx.kittycat.helper.Pref



/**
 * Created by simx on 06,September,2019
 */
class LoginActivityVM(private var pref:Pref):BaseObservable() {

    @Bindable var loading = MutableLiveData<Boolean>()
    @Bindable var success = MutableLiveData<Boolean>()
    @Bindable var isLogin = MutableLiveData<Boolean>()



    private val emailFake ="email@mail.com"
    private val passwordFake = "password"

    fun login(email:String, pass:String){

        loading.postValue(true)
        val correct = email == emailFake || pass == passwordFake
        success.postValue(correct)
        loading.postValue(!correct)
        pref.isLogin = correct

    }

    fun checkLoginState() {
        isLogin.postValue(pref.isLogin)
    }
}