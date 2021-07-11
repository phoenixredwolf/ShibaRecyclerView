package com.example.shibarecyclerview.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shibarecyclerview.databinding.ShibaItemBinding
import com.example.shibarecyclerview.util.loadImage

class ShibeAdapter(private val urls: List<String>) : RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShibeViewHolder {
        return ShibeViewHolder(
            ShibaItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShibeViewHolder, position: Int) {
        holder.bind(urls[position])
    }

    override fun getItemCount(): Int {
        return urls.size
    }

    class ShibeViewHolder(private val binding: ShibaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            with(binding) {
                shibeImage.loadImage(url)
            }
        }
    }
}