package com.health.dmcare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.health.dmcare.databinding.ItemRvTandaDanGejalaBinding
import com.health.dmcare.models.DataCardDiabetes

class LinierAdapter(private val items: List<DataCardDiabetes>)
    : RecyclerView.Adapter<LinierAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRvTandaDanGejalaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemRvTandaDanGejalaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DataCardDiabetes) {
            binding.ivTandaDanGejala.setImageResource(item.image)
            binding.tvTitTandaDanGejala.text = item.title
            binding.tvSubTandaDanGejala.text = item.description?: ""
        }
    }
}
