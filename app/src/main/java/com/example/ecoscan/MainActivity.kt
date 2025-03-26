package com.example.ecoscan

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import com.example.ecoscan.databinding.ActivityLabelDetailBinding
import com.example.ecoscan.ui.theme.EcoScanTheme
import com.example.ecoscan.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa o ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Ação do botão de escanear (simulado)
        binding.scanButton.setOnClickListener {
            Toast.makeText(this, "Produit scanné, ouverture des détails", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        // Ação do botão de explorar
        binding.exploreButton.setOnClickListener {
            val intent = Intent(this, ExplorerActivity::class.java)
            startActivity(intent)
        }
    }
}

