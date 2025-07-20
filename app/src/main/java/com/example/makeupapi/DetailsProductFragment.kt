package com.example.makeupapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil3.load
import com.example.makeupapi.databinding.FragmentDetailsProductBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DetailsProductFragment   : Fragment() {

lateinit var binding: FragmentDetailsProductBinding


@Inject
lateinit var service: ProductService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailsProductBinding.inflate(inflater,container,false)

        var productid=requireArguments().getInt(product_key)


        var callapiserviceById=service.getAllProductById(1047)
        callapiserviceById.enqueue(object : retrofit2.Callback<ResponseProduct>{
            override fun onResponse(
                call: Call<ResponseProduct>,
                response: Response<ResponseProduct>
            ) {

                if(response.code() == 200){
                    Log.i("TAG","onResponse: ${response.body()}")
                response.body()?.let {


                    binding.apply {

                        productName.text = it.name
                        productBrand.text = "Brand ${it.brand}"
                        productPrice.text = "${it.priceSign}: ${it.price} ( ${it.currency})"
                        productImage.load(it.imageLink)
productDescription.text=it.description
                        productCategory.text=it.category
                        productType.text=it.productType
                        productTags.text=it.tagList.toString()

                    }


                }
                }

            }

            override fun onFailure(call: Call<ResponseProduct>, t: Throwable) {

            }
        })




        return binding.root

    }

    companion object {
const val product_key="product_id_key"

    }
}