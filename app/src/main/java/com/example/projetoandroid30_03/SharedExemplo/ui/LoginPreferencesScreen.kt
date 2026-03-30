package com.example.projetoandroid30_03.SharedExemplo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetoandroid30_03.SharedExemplo.viewmodel.LoginPreferencesViewModel
import java.net.SocketAddress

@Composable
fun LoginPreferencesScreen(viewModel: LoginPreferencesViewModel = viewModel()) {
    val isLogged  by viewModel.isLogged

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = if (isLogged){
                "Usuario logado"
            }else{
                "Usuario Deslogado"
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




    }
}