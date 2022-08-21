package com.indah.kursusmobil.ui

import android.os.Bundle
import com.indah.kursusmobil.databinding.ActivityBukaTokoBinding
import com.indah.kursusmobil.ui.base.MyActivity
import com.indah.kursusmobil.ui.toko.TokoViewModel
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaruActivity : MyActivity() {

    private lateinit var binding: ActivityBukaTokoBinding
    private val viewModel: TokoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBukaTokoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Daftar Kursus")

        mainButton()
    }

    private fun mainButton() {

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}