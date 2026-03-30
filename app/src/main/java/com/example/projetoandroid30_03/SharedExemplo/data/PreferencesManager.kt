package com.example.projetoandroid30_03.SharedExemplo.data

import android.content.Context
import kotlinx.serialization.Contextual


class PreferencesManager(context: Context){
    private val prefs =  context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);

    fun saveLoginState(isLogged:Boolean){
        prefs.edit()
            .putBoolean("is_Logged", isLogged)
            .apply()
    }
    fun getLoginState(): Boolean{
        return prefs.getBoolean("is_Logged", false);
    }
}