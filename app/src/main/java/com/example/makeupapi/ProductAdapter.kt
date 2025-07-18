package com.example.makeupapi

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupapi.databinding.ItemProductBinding

class ProductAdapter  :ListAdapter<ResponseProduct, ProductAdapter.ProductViewViewHolder>() {
    class ProductViewViewHolder(var binding: ItemProductBinding)  :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductViewViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}