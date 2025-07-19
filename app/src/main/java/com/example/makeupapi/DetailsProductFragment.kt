package com.example.makeupapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.makeupapi.databinding.FragmentDetailsProductBinding
import retrofit2.Call
import retrofit2.Response

class DetailsProductFragment : Fragment() {

lateinit var binding: FragmentDetailsProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailsProductBinding.inflate(inflater,container,false)

        var productid=requireArguments().getInt(product_key)


        var callapiserviceById=RetrofitClient.service.getAllProductById(1047)
        callapiserviceById.enqueue(object : retrofit2.Callback<ResponseProduct>{
            override fun onResponse(
                call: Call<ResponseProduct>,
                response: Response<ResponseProduct>
            ) {

                if(response.code() == 200){
                    Log.i("TAG","onResponse: ${response.body()}")
                var product=response.body()

binding.apply {




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