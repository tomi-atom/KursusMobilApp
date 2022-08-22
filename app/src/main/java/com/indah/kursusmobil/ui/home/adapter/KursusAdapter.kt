package com.indah.kursusmobil.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indah.kursusmobil.core.data.source.model.Category
import com.indah.kursusmobil.core.data.source.model.Kursus
import com.indah.kursusmobil.databinding.ItemHomeCategoryBinding

@SuppressLint("NotifyDataSetChanged")
class KursusAdapter : RecyclerView.Adapter<KursusAdapter.ViewHolder>() {

    private var data = ArrayList<Kursus>()

    inner class ViewHolder(private val itemBinding: ItemHomeCategoryBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Kursus, position: Int) {
            itemBinding.apply {
                tvName.text = item.id_peserta

            }
        }
    }

    fun addItems(items: List<Kursus>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeCategoryBinding.inflate(
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