package com.example.makeupapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.makeupapi.databinding.FragmentAllProductBinding
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response


class AllProductFragment : Fragment() {
lateinit var binding: FragmentAllProductBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAllProductBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
var callapiservice=RetrofitClient.service.getAllProduct()
callapiservice.enqueue(object : retrofit2.Callback<List<ResponseProduct>>{
    override fun onResponse(
        call: Call<List<ResponseProduct>>,
        response: Response<List<ResponseProduct>>
    ) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<List<ResponseProduct>>, t: Throwable) {
        TODO("Not yet implemented")
    }
})
        return binding.root
    }

    companion object {





    }
}