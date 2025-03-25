package com.example.ecoscan

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ecoscan.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    // Binding généré automatiquement pour le layout activity_product_detail.xml
    private lateinit var binding: ActivityProductDetailBinding

    // Variable qui indique si le produit est actuellement ajouté aux favoris ou non
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisation du ViewBinding pour ce layout
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuration de la Toolbar : icône de navigation (retour)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish() // Ferme l'Activity (comportement similaire au "retour")
        }

        // Exemple de remplissage des données (statiques ici, mais pourrait provenir d'une API ou d'une base de données)
        binding.tvProductName.text = "Nom du produit"
        binding.tvBrand.text = "Producteur ou Marque"
        binding.tvRating.text = "5/10"
        binding.tvCertificationsTitle.text = "Classifications"
        binding.tvClassificationSubtitle.text = "La description du produit ici."
        binding.tvDescription.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultrices dolor est..."
        binding.tvNutritionalInfoTitle.text = "Information nutritionnelle"
        binding.tvNutritionalInfo.text = "Ingredients: Lorem ipsum dolor sit amet, consectetur adipiscing elit..."

        // Gestion du clic sur l'icône de favori (cœur)
        binding.ivFavorite.setOnClickListener {
            // Inverse l'état actuel (ajouté aux favoris ou non)
            isFavorite = !isFavorite

            if (isFavorite) {
                // Si on ajoute aux favoris
                Toast.makeText(this, "Produit ajouté aux favoris", Toast.LENGTH_SHORT).show()
                // Applique un filtre de couleur rouge sur l'icône
                binding.ivFavorite.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.holo_red_dark),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                // Si on retire des favoris
                Toast.makeText(this, "Produit retiré des favoris", Toast.LENGTH_SHORT).show()
                // Supprime le filtre de couleur pour revenir à l'icône d'origine (noir)
                binding.ivFavorite.clearColorFilter()
            }
        }

        // Gestion du clic sur le label (logo/sceau)
        binding.tvLabel.setOnClickListener {
            // Lance une nouvelle Activity pour les détails du label
            val intent = Intent(this, LabelDetailActivity::class.java)
            // Passe le nom du label dans l'Intent (via contentDescription)
            intent.putExtra("LABEL_NAME", binding.tvLabel.contentDescription.toString())
            startActivity(intent)
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