package com.health.dmcare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.dmcare.databinding.ItemRvDetailPengaturanNutrisiBinding
import com.health.dmcare.models.DataCardDiabetes

class ExpandStaggeredAdapter(private val items: List<DataCardDiabetes>)
    : RecyclerView.Adapter<ExpandStaggeredAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRvDetailPengaturanNutrisiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemRvDetailPengaturanNutrisiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: DataCardDiabetes) {
            binding.ivItemPengaturanNutrisi.setImageResource(items.image)
            binding.tvTitleItemPengaturanNutrisi.text = items.title
        }
    }
}