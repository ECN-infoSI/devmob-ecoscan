package com.example.ecoscan

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecoscan.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisation du ViewBinding
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuration de la Toolbar : icône de retour
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish() // Ferme l'Activity (similaire au "retour" en iOS)
        }

        // Exemple de remplissage de données (statiques ici, mais pourrait venir d’une API, d’une base de données, etc.)
        binding.tvProductName.text = "Nom du produit"
        binding.tvBrand.text = "Producteur ou Marque"
        binding.tvRating.text = "5/10"
        binding.tvClassificationTitle.text = "Classification"
        binding.tvClassificationSubtitle.text = "Brève explication de pourquoi le produit a cette classification"
        binding.tvDescription.text = "La description du produit ici. Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
        binding.tvCertificationsTitle.text = "Certifications"
        binding.tvNutritionalInfoTitle.text = "Information nutritionnelle"
        binding.tvNutritionalInfo.text = "Ingrédients: Lorem ipsum dolor sit amet..."

        // Gestion du clic sur l’icône favori (cœur)
        binding.ivFavorite.setOnClickListener {
            Toast.makeText(this, "Produit ajouté aux favoris", Toast.LENGTH_SHORT).show()
        }

        // Gestion du BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_scanner -> {
                    Toast.makeText(this, "Clique sur Scanner", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_explorer -> {
                    Toast.makeText(this, "Clique sur Explorer", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}