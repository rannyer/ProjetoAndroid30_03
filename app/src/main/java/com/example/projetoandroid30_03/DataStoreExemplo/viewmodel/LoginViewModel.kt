package com.example.projetoandroid30_03.DataStoreExemplo.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetoandroid30_03.DataStoreExemplo.data.DataStoreManager
import com.example.projetoandroid30_03.SharedExemplo.data.PreferencesManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application){

    private val dataStoreManager = DataStoreManager(application)

    val isLogged = dataStoreManager.getLoginState().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    fun login(){
        viewModelScope.launch {
            dataStoreManager.saveLoginState(true)
        }
    }

    fun logout(){
        viewModelScope.launch {
            dataStoreManager.saveLoginState(false)
        }
    }

}