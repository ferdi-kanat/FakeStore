package com.ferdikanat.fakestore.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ferdikanat.fakestore.model.Product
import com.ferdikanat.fakestore.service.ProductAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val productAPI = ProductAPIService()
    val products = MutableLiveData<List<Product>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    fun fetchProducts() {
        loading.value = true

        productAPI.getProducts().enqueue(object: Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    products.value = response.body()
                    error.value = false
                } else {
                    error.value = true
                }
                loading.value = false
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                loading.value = false
                error.value = true
                Log.e("RetrofitError", t.message.toString())
            }
        })
    }
}