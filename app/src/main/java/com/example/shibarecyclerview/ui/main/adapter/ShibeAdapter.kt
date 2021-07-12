package com.example.shibarecyclerview.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shibarecyclerview.databinding.ShibaItemBinding
import com.example.shibarecyclerview.util.loadImage

class ShibeAdapter(
    private val urls: List<String>,
    private val itemClicked: (String) -> Unit
) : RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = ShibeViewHolder.inflate(parent).also { holder ->
        holder.itemView.setOnClickListener {
            itemClicked.invoke(urls[holder.adapterPosition])
        }
    }

    override fun onBindViewHolder(holder: ShibeViewHolder, position: Int) = with(holder){
        bind(urls[position])
    }

    override fun getItemCount() = urls.size


    class ShibeViewHolder(
        private val binding: ShibaItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) = with(binding) {
                shibeImage.loadImage(url)
            }

        companion object {

            fun inflate(parent: ViewGroup) = ShibeViewHolder(
                ShibaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }


    }

}