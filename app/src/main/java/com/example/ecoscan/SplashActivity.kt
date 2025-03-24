package com.example.ecoscan

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.ecoscan.ui.theme.EcoScanTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Active les marges système (utile pour edge-to-edge UI)
        enableEdgeToEdge()

        // Définit le contenu de l'activité avec Jetpack Compose
        setContent {
            EcoScanTheme {
                // Appelle le composant SplashScreen et passe une fonction pour passer à l'écran suivant
                SplashScreen {
                    // Lance l'activité principale après le délai
                    startActivity(Intent(this, MainActivity::class.java))
                    // Ferme l'écran de splash pour qu'on ne puisse pas y revenir en arrière
                    finish()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(true) {
        delay(1500)
        onTimeout()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Logo ÉcoScan",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}