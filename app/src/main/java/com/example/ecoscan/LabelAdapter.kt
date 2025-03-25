package com.example.ecoscan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class LabelAdapter(private val labelList: List<Label>) :
    RecyclerView.Adapter<LabelAdapter.LabelViewHolder>() {

    class LabelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val labelImage: ImageView = view.findViewById(R.id.labelImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_label, parent, false)
        return LabelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LabelViewHolder, position: Int) {
        val label = labelList[position]
        holder.labelImage.setImageResource(label.imageResId) // Ícone do label
    }

    override fun getItemCount() = labelList.size
}
