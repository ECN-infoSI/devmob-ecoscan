package com.example.ecoscan

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ecoscan.databinding.ActivityLabelDetailBinding

class LabelDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLabelDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisation du ViewBinding
        binding = ActivityLabelDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuration de la Toolbar : icône de retour
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish() // Ferme l'Activity (similaire au bouton "retour" sur iOS)
        }

        // Remplissage des données du label (ces données pourraient venir d'une API à l'avenir)
        val labelName = intent.getStringExtra("LABEL_NAME") ?: "Label inconnu"
        binding.tvLabelName.text = labelName
        binding.tvCategory.text = "Gestion durable des forêts"
        binding.tvRegulatoryBody.text = "   - Certification de la gestion forestière responsable\n" +
                "   - Assure la traçabilité des matériaux boisés\n" +
                "   - Encourage la biodiversité et la protection des écosystèmes"
        binding.tvDescription.text = "Le label FSC garantit que les produits en bois et en papier proviennent de forêts gérées de manière responsable et durable. Il vise à préserver les écosystèmes forestiers, à respecter les droits des populations locales et à assurer une exploitation équitable des ressources naturelles.\n" +
                "Grâce à ses exigences strictes, il est reconnu mondialement comme un gage de durabilité et de qualité environnementale."
        binding.tvCriteria.text = "  - Gestion durable et responsable des forêts\n" +
                "   - Protection des droits des travailleurs et des communautés locales\n" +
                "   - Respect de la biodiversité et des écosystèmes\n" +
                "   - Réduction de l'empreinte écologique de l'exploitation forestière"

        // Configuration du bouton Favoris
        var isFavorite = false

        // Clic sur le label pour ouvrir les détails du produit
        binding.lait.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        binding.ivFavorite.setOnClickListener {
            isFavorite = !isFavorite  // Change l'état du favori

            if (isFavorite) {
                Toast.makeText(this, "$labelName ajouté aux favoris", Toast.LENGTH_SHORT).show()

                // Applique un filtre de couleur rouge sur l'icône
                binding.ivFavorite.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.holo_red_dark),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                Toast.makeText(this, "$labelName retiré des favoris", Toast.LENGTH_SHORT).show()

                // Supprime le filtre de couleur pour revenir à l'icône d'origine (noir)
                binding.ivFavorite.clearColorFilter()
            }
        }

        // Gestion du BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_scanner -> {
                    Toast.makeText(this, "Clic sur Scanner", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_explorer -> {
                    Toast.makeText(this, "Clic sur Explorer", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }
}
