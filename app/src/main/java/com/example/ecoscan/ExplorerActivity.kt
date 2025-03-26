package com.example.ecoscan

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.SearchView
import com.example.ecoscan.databinding.ActivityExplorerBinding

class ExplorerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExplorerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Démarre ViewBinding
        binding = ActivityExplorerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Gestion du Bouton de Profil
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_profile -> {
                    Toast.makeText(this, "Clique sur Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        //Definition de la phrase dans la barre de recherche
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.queryHint = getString(R.string.rechercher)

        //Gestion des clicks sur des produits
        binding.ivrProductLait.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        binding.ivsProductLait.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        //Gestion des clicks sur des labels
        binding.ivLabelFsc.setOnClickListener {
            val intent = Intent(this, LabelDetailActivity::class.java)
            startActivity(intent)
        }

        //Gestion du Bouton de Scanner
        binding.extendedFab.setOnClickListener {
            Toast.makeText(this, "Scan ouvert", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}

