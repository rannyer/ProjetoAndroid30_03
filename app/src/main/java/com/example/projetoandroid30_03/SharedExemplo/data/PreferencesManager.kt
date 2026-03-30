package com.example.projetoandroid30_03.SharedExemplo.data

import android.content.Context
import kotlinx.serialization.Contextual


class PreferencesManager(context: Context){
    private val prefs =  context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);

    companion object{
        private const val KEY_IS_LOGGED = "is_logged"
        private const val KEY_USER_TYPE = "user_type"

    }


    fun saveUserType(type:String){
            prefs.edit()
                .putString(KEY_USER_TYPE, type)
                .apply()
    }
    fun getUserType():String{
        return  prefs.getString(KEY_USER_TYPE, "USER") ?: "USER"
    }
    fun saveLoginState(isLogged:Boolean){
        prefs.edit()
            .putBoolean(KEY_IS_LOGGED, isLogged)
            .apply()
    }
    fun getLoginState(): Boolean{
        return prefs.getBoolean("is_Logged", false);
    }
}