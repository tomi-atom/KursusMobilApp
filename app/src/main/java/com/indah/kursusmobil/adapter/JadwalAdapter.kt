package com.indah.kursusmobil.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indah.kursusmobil.core.data.source.model.Jadwal
import com.indah.kursusmobil.databinding.ItemAlamatTokoBinding
import com.indah.kursusmobil.ui.jadwal.EditJadwalActivity
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.popUpMenu
import com.inyongtisto.myhelper.extension.toJson

@SuppressLint("NotifyDataSetChanged")
class JadwalAdapter(val onDelete: (item: Jadwal, pos: Int) -> Unit) :
    RecyclerView.Adapter<JadwalAdapter.ViewHolder>() {

    private var data = ArrayList<Jadwal>()

    inner class ViewHolder(private val itemBinding: ItemAlamatTokoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Jadwal, position: Int) {
            itemBinding.apply {

                val context = root.context
                btnMenu.setOnClickListener {
                    val listMenu = listOf("Detail", "Hapus")
                    context.popUpMenu(btnMenu, listMenu) {
                        when (it) {
                            "Detail" -> context.intentActivity(
                                EditJadwalActivity::class.java,
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

    fun addItems(items: List<Jadwal>) {
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