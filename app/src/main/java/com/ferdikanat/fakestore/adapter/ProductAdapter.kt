package com.ferdikanat.fakestore.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ferdikanat.fakestore.R
import com.ferdikanat.fakestore.databinding.ItemProductBinding
import com.ferdikanat.fakestore.model.Product
import com.ferdikanat.fakestore.util.downloadImage

class ProductAdapter(private var productList: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemProductBinding = DataBindingUtil.inflate(inflater, R.layout.item_product, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.productTitle.text = productList[position].title
        holder.binding.productPrice.text = productList[position].price.toString()
        holder.binding.productImage.downloadImage(productList[position].image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateProductList(newProductList: List<Product>) {
        productList.clear()
        productList.addAll(newProductList)
        notifyDataSetChanged()
    }
}
