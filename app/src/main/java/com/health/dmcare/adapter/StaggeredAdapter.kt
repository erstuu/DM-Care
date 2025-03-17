package com.health.dmcare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.dmcare.databinding.ItemRvDetailTandaDanGejalaBinding
import com.health.dmcare.models.DataCardDiabetes

class StaggeredAdapter(private val items: List<DataCardDiabetes>)
    : RecyclerView.Adapter<StaggeredAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRvDetailTandaDanGejalaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemRvDetailTandaDanGejalaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: DataCardDiabetes) {
            binding.ivTandaDanGejala.setImageResource(items.image)
            binding.tvTitTandaDanGejala.text = items.title
        }
    }
}