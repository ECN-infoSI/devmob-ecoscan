package com.example.ecoscan

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExplorerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explorer)

        // Configurar SearchView
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@ExplorerActivity, "Recherche : $query", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        //Configurar RecyclerViews
        findViewById<RecyclerView>(R.id.recyclerViewRecent).adapter = ProductAdapter(getRecentProducts())
        findViewById<RecyclerView>(R.id.recyclerViewSuggested).adapter = ProductAdapter(getSuggestedProducts())
        findViewById<RecyclerView>(R.id.recyclerViewLabels).adapter = LabelAdapter(getLabels())

        // Configurar botão scanner
        findViewById<FloatingActionButton>(R.id.fab_scanner).setOnClickListener {
            Toast.makeText(this, "Scanner ouvert!", Toast.LENGTH_SHORT).show()
        }

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_toolbar, menu)
            return true
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_profile -> {
                    Toast.makeText(this, "Profil", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }

    }

    private fun getRecentProducts(): List<Product> {
        return listOf(
            Product("Lait Amande Intense", R.drawable.produit_lait),
            Product("Pain de mie céréales", R.drawable.produit_pain),
            Product("Yaourt", R.drawable.produit_yaourt)
        )
    }

    private fun getSuggestedProducts(): List<Product> {
        return listOf(
            Product("Lait Amande Intense", R.drawable.produit_lait),
            Product("Pain de mie céréales", R.drawable.produit_pain),
            Product("Yaourt", R.drawable.produit_yaourt)
        )
    }

    private fun getLabels(): List<Label> {
        return listOf(
            Label(R.drawable.label_fsc),
            Label(R.drawable.label_triman),
            Label(R.drawable.label_france)
        )
    }
}
