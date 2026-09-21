package com.example.pemesanantiket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigator()
                }
            }
        }
    }
}

@Composable
fun AppNavigator() {
    var currentScreen by remember { mutableStateOf(0) }

    when (currentScreen) {
        0 -> MenuScreen(onNavigate = { currentScreen = it })
        1 -> ChangeTextScreen()
        2 -> EventStateScreen()
        3 -> ImplicitIntentScreen()
        4 -> TicketBookingScreen()
    }
}

@Composable
fun MenuScreen(onNavigate: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Modul 3 - Menu Percobaan", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onNavigate(1) }, modifier = Modifier.fillMaxWidth()) {
            Text("Percobaan: Deklaratif (ChangeText)")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onNavigate(2) }, modifier = Modifier.fillMaxWidth()) {
            Text("Percobaan: Event Handling State")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onNavigate(3) }, modifier = Modifier.fillMaxWidth()) {
            Text("Percobaan: Implicit Intent")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onNavigate(4) }, modifier = Modifier.fillMaxWidth()) {
            Text("TUGAS: Pemesanan Tiket")
        }
    }
}