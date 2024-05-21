package com.ferdikanat.fakestore.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductAPIService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(ProductAPI::class.java)

    fun getProducts() = api.getProducts()
}