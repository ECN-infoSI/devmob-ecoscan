package com.example.ecoscan

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecoscan.ui.theme.EcoScanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoScanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello Android!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Inicia a ProductDetailActivity
            context.startActivity(Intent(context, ProductDetailActivity::class.java))
        }) {
            Text("Montrer les details du produit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcoScanTheme {
        Content()
    }
}