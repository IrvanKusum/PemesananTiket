package com.example.pemesanantiket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicketBookingScreen() {
    val hargaTiket = 25000
    var jumlahTiket by remember { mutableStateOf(1) }
    val totalBayar = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            color = Color(0xFF2196F3),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "🎫", fontSize = 32.sp)
                Text(
                    text = "Pemesanan Tiket",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Pesan tiket dengan mudah!",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(title = "Harga Tiket") {
            Text(
                text = "Rp${"%,d".format(hargaTiket).replace(",", ".")}",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3)
            )
            Text(text = "per tiket", fontSize = 12.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(12.dp))

        InfoCard(title = "Jumlah Tiket") {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { if (jumlahTiket > 1) jumlahTiket-- },
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFF2196F3), shape = RoundedCornerShape(50))
                ) {
                    Text("−", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

                Text(
                    text = "$jumlahTiket",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = { jumlahTiket++ },
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFF2196F3), shape = RoundedCornerShape(50))
                ) {
                    Text("+", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        InfoCard(title = "Total") {
            Text(
                text = "Rp${"%,d".format(totalBayar).replace(",", ".")}",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { jumlahTiket = 1 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("RESET", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun InfoCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFF5F5F5),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(4.dp))
            content()
        }
    }
}