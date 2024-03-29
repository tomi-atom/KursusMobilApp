package com.indah.kursusmobil.ui.kursus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indah.kursusmobil.databinding.ActivityKursusSayaBinding
import com.indah.kursusmobil.ui.jadwal.ListJadwalActivity
import com.indah.kursusmobil.util.Prefs
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.setToolbar

class KursusSayaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKursusSayaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKursusSayaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Kursus Saya")
        // get data dari server

        setData()
        setupListener()
    }

    private fun setData() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                if (user.kursus != null) {

                }
            }
        }
    }

    private fun setupListener() {
        binding.apply {
            btnAlamat.setOnClickListener {
                intentActivity(ListJadwalActivity::class.java)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}