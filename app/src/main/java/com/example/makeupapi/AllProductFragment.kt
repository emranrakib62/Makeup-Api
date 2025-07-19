package com.example.makeupapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.makeupapi.databinding.FragmentAllProductBinding
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response


class AllProductFragment : Fragment() ,ProductAdapter.ProductListener{
    lateinit var adapter: ProductAdapter



lateinit var binding: FragmentAllProductBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAllProductBinding.inflate(inflater,container,false)
        adapter=ProductAdapter()
        binding.productitemrcv.adapter=adapter

        var callapiserviceById=RetrofitClient.service.getAllProductById(1047)
        callapiserviceById.enqueue(object : retrofit2.Callback<ResponseProduct>{
            override fun onResponse(
                call: Call<ResponseProduct>,
                response: Response<ResponseProduct>
            ) {

if(response.code() == 200){
    Log.i("TAG","onResponse: ${response.body()}")
}

            }

            override fun onFailure(call: Call<ResponseProduct>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        // Inflate the layout for this fragment
var callapiservice=RetrofitClient.service.getAllProduct()
callapiservice.enqueue(object : retrofit2.Callback<List<ResponseProduct>>{
    override fun onResponse(
        call: Call<List<ResponseProduct>>,
        response: Response<List<ResponseProduct>>
    ) {

        if (response.code()==200){
            response.body()
adapter.submitList(response.body())

        }
    }

    override fun onFailure(call: Call<List<ResponseProduct>>, t: Throwable) {
Toast.makeText(requireContext(),"${t.message}",Toast.LENGTH_LONG).show()
    }
})
        return binding.root
    }

    companion object {





    }

    override fun ProductClickedListener(productId: Int) {
        TODO("Not yet implemented")
    }
}