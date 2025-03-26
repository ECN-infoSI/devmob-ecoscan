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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import com.example.ecoscan.ui.theme.EcoScanTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Active les marges système (utile pour edge-to-edge UI)
        enableEdgeToEdge()

        // Définit le contenu de l’activité avec Jetpack Compose
        setContent {
            EcoScanTheme {
                // Appelle le composant SplashScreen et passe une fonction pour passer à l’écran suivant
                SplashScreen {
                    // Lance l’activité ExplorerActivity après le délai
                    startActivity(Intent(this, ExplorerActivity::class.java))
                    // Ferme l’écran splash pour qu’on ne puisse pas y revenir en arrière
                    finish()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Lance un effet dès que le composant est affiché
    LaunchedEffect(true) {
        // Attend 1.5 seconde (1500 millisecondes)
        delay(1500)
        // Appelle la fonction passée en paramètre (pour naviguer vers ExplorerActivity)
        onTimeout()
    }

    // Mise en page de l’écran de bienvenue
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Colonne centrée verticalement et horizontalement
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Affiche l’image d’accueil (le logo)
            Image(
                painter = painterResource(id = R.drawable.welcome), // Image du dossier drawable
                contentDescription = "Logo ÉcoScan",
            )
        }
    }
}