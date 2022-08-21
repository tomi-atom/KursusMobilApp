package com.indah.kursusmobil.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indah.kursusmobil.core.data.source.model.Category
import com.indah.kursusmobil.core.data.source.model.Product
import com.indah.kursusmobil.databinding.ItemHomeCategoryBinding
import com.indah.kursusmobil.databinding.ItemHomeProdukTerbaruBinding
import com.indah.kursusmobil.databinding.ItemHomeProdukTerlarisBinding
import com.inyongtisto.myhelper.extension.coret
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toRupiah
import com.inyongtisto.myhelper.extension.toVisible

@SuppressLint("NotifyDataSetChanged")
class ProductTerbaruAdapter : RecyclerView.Adapter<ProductTerbaruAdapter.ViewHolder>() {

    private var data = ArrayList<Product>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukTerbaruBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Product, position: Int) {
            itemBinding.apply {
                val harga = item.harga ?: 0
                tvName.text = item.name
                imageView.setImageResource(item.image)
                tvHarga.text = item.harga.toRupiah()
                tvPengiriman.text = item.pengirirman
                tvReting.text = "" + item.rating + " | Terjual" + item.terjual

                if (item.discount != 0) {
                    lyGrosir.toGone()
                    lyDiskon.toVisible()
                    tvDiscount.text = "${item.discount}%"

                    tvHarga.text = (harga - ((item.discount.toDouble() / 100) * harga)).toRupiah()
                    tvHargaAsli.text = item.harga.toRupiah()
                    tvHargaAsli.coret()
                }
            }
        }
    }

    fun addItems(items: List<Product>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeProdukTerbaruBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}