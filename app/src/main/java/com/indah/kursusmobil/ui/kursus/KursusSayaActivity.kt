package com.indah.kursusmobil.ui.kursus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indah.kursusmobil.databinding.ActivityTokoSayaBinding
import com.indah.kursusmobil.ui.alamatToko.ListAlamatTokoActivity
import com.indah.kursusmobil.util.Constants
import com.indah.kursusmobil.util.Prefs
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.setToolbar
import com.squareup.picasso.Picasso

class KursusSayaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTokoSayaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokoSayaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Toko Saya")
        // get data dari server

        setData()
        setupListener()
    }

    private fun setData() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                if (user.toko != null) {
                    tvName.text = user.toko?.name
                    tvInisial.text = user.toko?.name.getInitial()
                    Picasso.get().load(Constants.USER_URL + user.toko?.name)
                        .into(binding.imageProfile)
                }
            }
        }
    }

    private fun setupListener() {
        binding.apply {
            btnAlamat.setOnClickListener {
                intentActivity(ListAlamatTokoActivity::class.java)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}