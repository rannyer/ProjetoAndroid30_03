package com.example.projetoandroid30_03.SharedExemplo.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.projetoandroid30_03.SharedExemplo.data.PreferencesManager

class LoginPreferencesViewModel(application: Application): AndroidViewModel(application){
    private val preferencesManager = PreferencesManager(application)

    var isLogged = mutableStateOf(false)
        private set

    init{
        loadLoginState()
    }

    private fun loadLoginState(){
        isLogged.value = preferencesManager.getLoginState()
    }

    fun login(){
        preferencesManager.saveLoginState(true)
        isLogged.value = true
    }

    fun logout(){
        preferencesManager.saveLoginState(false)
        isLogged.value = false
    }

}