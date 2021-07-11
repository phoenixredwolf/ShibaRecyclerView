package com.example.shibarecyclerview.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shibarecyclerview.R
import com.example.shibarecyclerview.data.Shiba

class MainRecyclerAdapter(val context: Context, val shibas: List<Shiba>):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) :
                RecyclerView.ViewHolder(itemView) {
                    val shibaImage = itemView.findViewById<ImageView>(R.id.shibaImage)
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.shiba_grid_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shiba = shibas[position]
        with(holder) {
            Glide.with(context).load(shiba.url).into(shibaImage)
        }
    }

    override fun getItemCount() = shibas.size
}