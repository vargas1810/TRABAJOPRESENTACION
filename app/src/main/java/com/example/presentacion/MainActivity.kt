package com.example.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import com.example.presentacion.ui.theme.PresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del logo de Android
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Nombre
        Text(
            text = "Jennifer Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Título
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Información de contacto con formas básicas
        ContactInfoRow(icon = { SimpleCircle() }, info = "+11 (123) 444 555 666")
        Spacer(modifier = Modifier.height(8.dp))
        ContactInfoRow(icon = { SimpleCircle() }, info = "@AndroidDev")
        Spacer(modifier = Modifier.height(8.dp))
        ContactInfoRow(icon = { SimpleCircle() }, info = "jen.doe@android.com")
    }
}

@Composable
fun ContactInfoRow(icon: @Composable () -> Unit, info: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        icon()

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = info,
            fontSize = 14.sp
        )
    }
}

@Composable
fun SimpleCircle() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color.Gray, shape = CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    PresentacionTheme {
        BusinessCardScreen()
    }
}
