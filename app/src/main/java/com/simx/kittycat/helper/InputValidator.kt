package com.simx.kittycat.helper

import android.util.Patterns
import com.google.android.material.textfield.TextInputEditText

/**
 * Created by simx on 06,September,2019
 */
object InputValidator {

    fun isValidPassword(view: TextInputEditText):Boolean {
        return if (view.text.isNullOrEmpty() && view.text?.length!! <= 3){
            view.error = "Required / Minimal 3 charater"
            false
        } else {
            view.error = null
            true
        }
    }
    fun isValidEmail(view: TextInputEditText): Boolean{

        return if (!isEmail(view.text.toString())){
            view.error = "Invalid email address"
            false
        }else {
            view.error = null
            true
        }
    }

    private fun isEmail(value:String): Boolean {
        return  Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}