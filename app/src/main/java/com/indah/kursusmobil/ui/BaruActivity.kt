package com.indah.kursusmobil.ui

import android.os.Bundle
import com.indah.kursusmobil.databinding.ActivityBukaKursusBinding
import com.indah.kursusmobil.ui.base.MyActivity
import com.indah.kursusmobil.ui.kursus.KursusViewModel
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaruActivity : MyActivity() {

    private lateinit var binding: ActivityBukaKursusBinding
    private val viewModel: KursusViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBukaKursusBinding.inflate(layoutInflater)
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