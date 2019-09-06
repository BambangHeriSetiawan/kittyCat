package com.simx.kittycat.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.simx.kittycat.MainActivity
import com.simx.kittycat.R
import com.simx.kittycat.databinding.LoginActivityBinding
import com.simx.kittycat.helper.InputValidator
import com.simx.kittycat.helper.Pref

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:LoginActivityBinding
    private lateinit var vm:LoginActivityVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.login_activity)
        vm = LoginActivityVM(Pref(this))
        binding.lifecycleOwner = this
        binding.loginVm = vm
        vm.checkLoginState()
        vm.isLogin.observe(this, Observer { login -> run {
            if (login)goToMain()
        } })
        binding.btnLogin.setOnClickListener {
            Log.v("LoginActivity","onCreate -> ")
            if (InputValidator.isValidEmail(binding.etEmail) && InputValidator.isValidPassword(binding.etPass)){
                vm.login(binding.etEmail.text.toString(),binding.etPass.text.toString())
            }
        }
        vm.success.observe(this, Observer { isSuccess -> run {
            if (isSuccess) goToMain() else showErrorMsg("Something wrong")
        } })

        vm.loading.observe(this, Observer { state -> run {
            if (state) {
                binding.btnLogin.visibility = View.GONE
                binding.progress.visibility = View.VISIBLE
            }else {
                binding.btnLogin.visibility = View.VISIBLE
                binding.progress.visibility = View.GONE
            }

        } })
    }

    private fun showErrorMsg(msg: String) {
        vm.loading.postValue(false)
        Snackbar.make(binding.rootView, msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun goToMain(){
        MainActivity.start(this)
        finish()
    }
    companion object {
        fun start(context: Context){
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}
