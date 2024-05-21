package com.ferdikanat.fakestore.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdikanat.fakestore.R
import com.ferdikanat.fakestore.adapter.ProductAdapter
import com.ferdikanat.fakestore.databinding.ActivityMainBinding
import com.ferdikanat.fakestore.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var productAdapter = ProductAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        observeViewModel()
        viewModel.fetchProducts()
    }

    private fun observeViewModel() {
        viewModel.products.observe(this) { products ->
            products?.let {
                productAdapter.updateProductList(it)
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            isLoading?.let {
                binding.loadingProgressBar.visibility = if (it) View.VISIBLE else View.GONE
            }
        }

        viewModel.error.observe(this) { isError ->
            isError?.let {
                binding.errorTextView.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
    }
}
