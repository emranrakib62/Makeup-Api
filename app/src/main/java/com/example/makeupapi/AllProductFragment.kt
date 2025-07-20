import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.makeupapi.DetailsProductFragment
import com.example.makeupapi.ProductAdapter
import com.example.makeupapi.ProductService
import com.example.makeupapi.R
import com.example.makeupapi.ResponseProduct
import com.example.makeupapi.databinding.FragmentAllProductBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class AllProductFragment : Fragment(), ProductAdapter.ProductListener {

    @Inject
    lateinit var service: ProductService

    private lateinit var adapter: ProductAdapter
    private lateinit var binding: FragmentAllProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllProductBinding.inflate(inflater, container, false)
        adapter = ProductAdapter(this)
        binding.productitemrcv.adapter = adapter

        val callapiservice = service.getAllProduct()
        callapiservice.enqueue(object : retrofit2.Callback<List<ResponseProduct>> {
            override fun onResponse(
                call: Call<List<ResponseProduct>>,
                response: Response<List<ResponseProduct>>
            ) {
                if (response.code() == 200) {
                    adapter.submitList(response.body())
                }
            }

            override fun onFailure(call: Call<List<ResponseProduct>>, t: Throwable) {
                Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

    override fun ProductClickedListener(productId: Int) {
        val bundle = Bundle()
        bundle.putInt(DetailsProductFragment.product_key, productId)

        findNavController().navigate(R.id.action_allProductFragment_to_detailsProductFragment, bundle)
    }
}
