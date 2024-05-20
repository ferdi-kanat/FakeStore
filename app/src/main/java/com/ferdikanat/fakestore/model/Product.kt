package com.ferdikanat.fakestore.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("image")
    val image: String
)