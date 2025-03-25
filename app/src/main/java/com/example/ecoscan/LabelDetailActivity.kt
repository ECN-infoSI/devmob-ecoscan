package com.example.ecoscan

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecoscan.databinding.ActivityLabelDetailBinding

class LabelDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLabelDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o ViewBinding
        binding = ActivityLabelDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuration de la Toolbar : icône de retour
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish() // Ferme l'Activity (similaire au "retour" en iOS)
        }

        // Preenchimento de dados do selo (dados podem vir de API futuramente)
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

        // Configuração do botão de favoritos
        var isFavorite = false


        // Clique no selo para abrir detalhes do label
        binding.lait.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        binding.ivFavorite.setOnClickListener {
            isFavorite = !isFavorite  // Alterna o estado do favorito

            if (isFavorite) {
                binding.ivFavorite.setImageResource(R.drawable.heart) // Define a imagem vermelha
                Toast.makeText(this, "$labelName ajouté aux favoris", Toast.LENGTH_SHORT).show()
            } else {
                binding.ivFavorite.setImageResource(R.drawable.grey_heart) // Retorna à imagem cinza
                Toast.makeText(this, "$labelName retiré des favoris", Toast.LENGTH_SHORT).show()
            }
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
