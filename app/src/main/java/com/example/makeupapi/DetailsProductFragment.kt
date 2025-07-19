package com.example.makeupapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.makeupapi.databinding.FragmentDetailsProductBinding

class DetailsProductFragment : Fragment() {

lateinit var binding: FragmentDetailsProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailsProductBinding.inflate(inflater,container,false)
        return binding.root

    }

    companion object {
const val product_key="product_id_key"

    }
}