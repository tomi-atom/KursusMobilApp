package com.indah.kursusmobil.ui.alamatToko.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indah.kursusmobil.core.data.source.model.AlamatToko
import com.indah.kursusmobil.databinding.ItemAlamatTokoBinding
import com.indah.kursusmobil.ui.alamatToko.EditAlamatTokoActivity
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.popUpMenu
import com.inyongtisto.myhelper.extension.toJson

@SuppressLint("NotifyDataSetChanged")
class HomeAdapter(val onDelete: (item: AlamatToko, pos: Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var data = ArrayList<AlamatToko>()

    inner class ViewHolder(private val itemBinding: ItemAlamatTokoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: AlamatToko, position: Int) {
            itemBinding.apply {
                tvKota.text = item.kota
                var kecamatan = ""
                if (item.kecamatan != null) kecamatan = ", Kec. ${item.kecamatan}"

                tvAlamat.text =
                    "${item.alamat}$kecamatan, ${item.kota}, ${item.provinsi}, ${item.kodepost}"
                tvEmail.text = item.email
                tvPhone.text = item.phone_number

                val context = root.context
                btnMenu.setOnClickListener {
                    val listMenu = listOf("Detail", "Hapus")
                    context.popUpMenu(btnMenu, listMenu) {
                        when (it) {
                            "Detail" -> context.intentActivity(
                                EditAlamatTokoActivity::class.java,
                                item.toJson()
                            )
                            "Hapus" -> onDelete.invoke(item, adapterPosition)
                        }
                    }
                }
            }
        }
    }

    fun removeAt(index: Int) {
        data.removeAt(index)
        notifyItemRemoved(index)
    }

    fun addItems(items: List<AlamatToko>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlamatTokoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}