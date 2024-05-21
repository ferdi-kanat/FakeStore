package com.ferdikanat.fakestore.service

import com.ferdikanat.fakestore.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}