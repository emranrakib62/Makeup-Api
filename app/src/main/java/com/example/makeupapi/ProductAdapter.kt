package com.example.makeupapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load

import com.example.makeupapi.databinding.ItemProductRcvBinding

class ProductAdapter  :ListAdapter<ResponseProduct, ProductAdapter.ProductViewViewHolder>(COMPARATOR) {
    class ProductViewViewHolder(var binding: ItemProductRcvBinding)  :
        RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewViewHolder {
        return ProductViewViewHolder(ItemProductRcvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }





    override fun onBindViewHolder(holder: ProductViewViewHolder, position: Int) {
        getItem(position)?.let {


            holder.binding.apply {
productName.text=it.name
                productBrand.text="Brand ${it.brand}"
                productPrice.text="${it.priceSign}: ${it.price} ( ${it.currency})"
productImage.load(it.apiFeaturedImage)

        }


        }
    }

    companion object {

        var COMPARATOR = object : DiffUtil.ItemCallback<ResponseProduct>(){
            override fun areItemsTheSame(
                oldItem: ResponseProduct,
                newItem: ResponseProduct
            ): Boolean {
                return oldItem==newItem

            }

            override fun areContentsTheSame(
                oldItem: ResponseProduct,
                newItem: ResponseProduct
            ): Boolean {
               return oldItem.id==newItem.id
            }
        }

    }


}