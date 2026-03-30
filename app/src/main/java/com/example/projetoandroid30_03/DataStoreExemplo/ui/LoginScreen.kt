package com.example.projetoandroid30_03.DataStoreExemplo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetoandroid30_03.DataStoreExemplo.viewmodel.LoginViewModel
import com.example.projetoandroid30_03.SharedExemplo.viewmodel.LoginPreferencesViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {

    val isLogged by viewModel.isLogged.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = if (isLogged){
                "Usuario logado Store"
            }else{
                "Usuario Deslogado Store"
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {viewModel.login()}) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {viewModel.logout()}) {
            Text("Logou")
        }
        Spacer(modifier = Modifier.height(32.dp))











    }
}