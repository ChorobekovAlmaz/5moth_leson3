package com.example.a5moth_leson3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.a5moth_leson3.databinding.ItemImageBinding

class PixaAdapter(var list:ArrayList<ImageModel>) :Adapter<PixaAdapter.PixaViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return PixaViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =list.size



    inner class PixaViewHolder(var binding: ItemImageBinding):ViewHolder(binding.root){
    fun  onBind(imageModel:ImageModel){
        binding.imagePicView.load(imageModel.largeImageURL)
    }

    }
}