package com.example.projetoandroid30_03.DataStoreExemplo.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context){

    companion object{
        private val IS_LOGGED = booleanPreferencesKey("is_Logged")
    }

    fun getLoginState(): Flow<Boolean>{
        return  context.dataStore.data.map { preferences: Preferences ->
            preferences[IS_LOGGED] ?: false
        }
    }

    suspend fun saveLoginState(isLogged: Boolean){
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED]  = isLogged
        }
    }

}