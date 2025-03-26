package com.example.ecoscan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ecoscan.databinding.ActivityExplorerBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class ExplorerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExplorerBinding
    //private var lateinit searchView: SearchView;
    //private var lateinit resultsView: ListView;

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


        //Gestion du moteur de recherche
        //searchView = findViewById(R.id.searchView);
        //resultsView = findViewById(R.id.resultsView);

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
        }


    }


}

