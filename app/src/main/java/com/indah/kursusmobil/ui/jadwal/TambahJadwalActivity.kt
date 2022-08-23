package com.indah.kursusmobil.ui.jadwal

import android.os.Bundle
import com.indah.kursusmobil.core.data.source.model.AlamatToko
import com.indah.kursusmobil.core.data.source.model.Jadwal
import com.indah.kursusmobil.core.data.source.remote.network.State
import com.indah.kursusmobil.databinding.ActivityTambahJadwalBinding
import com.indah.kursusmobil.ui.base.MyActivity
import com.indah.kursusmobil.util.defaultError
import com.indah.kursusmobil.util.getKursusId
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TambahJadwalActivity : MyActivity() {

    private lateinit var binding: ActivityTambahJadwalBinding
    private val viewModel: JadwalViewModel by viewModel()
    private var provinsiId: Int? = null
    private var kotaId: Int? = null
    private var kecamatanId: Int? = null
    private var provinsi: String? = null
    private var kota: String? = null
    private var kecamatan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahJadwalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Tambah Jadwal")

        setupUI()
        mainButton()
    }

    private fun setupUI() {
        // 0, 1, 2, 3
        val listProvinsi = listOf("Pilih Provinsi", "Jawa Timur", "Jawa Tengah", "Jawa Barat")
        val listKota = listOf("Pilih Kota", "Lamongan", "Semarang", "Bogor")
        val listKecamatan = listOf("Pilih Kecamatan", "Solokuro", "Ngalian", "Ngaglik")

        /*binding.spnProvinsi.setOnPositionSelectedListener(this, listProvinsi) {
            if (it == 0) {
                provinsiId = null
            } else {
                // it == 1
                provinsiId = 10
                provinsi = listProvinsi[it]
            }
        }

        binding.spnKota.setOnPositionSelectedListener(this, listKota) {
            if (it == 0) {
                kotaId = null
            } else {
                // it == 1
                kotaId = 399
                kota = listKota[it]
            }
        }

        binding.spnKecamatan.setOnPositionSelectedListener(this, listKecamatan) {
            if (it == 0) {
                kecamatanId = null
            } else {
                // it == 1
                kecamatanId = 5505
                kecamatan = listKecamatan[it]
            }
        }*/
    }

    private fun mainButton() {
        binding.apply {
            lyToolbar.btnSimpan.toVisible()
            lyToolbar.btnSimpan.setOnClickListener {
                if (validate()) simpan()
            }
            lyToolbar.btnSimpan.setOnLongClickListener {
              //  edtLabel.setText("Rumah")
                //edtAlamat.setText("Jl. Kenangan bersama mantan")
                //edtKodePos.setText("98347")
                //edtEmail.setText("email@gmail.com")
                //edtPhone.setText("0812345678")
                return@setOnLongClickListener true
            }
        }
    }

    private fun validate(): Boolean {
        binding.apply {
           /* if (edtLabel.isEmpty()) return false
            if (edtAlamat.isEmpty()) return false
            if (edtKodePos.isEmpty()) return false
            if (edtEmail.isEmpty()) return false
            if (edtPhone.isEmpty()) return false
            if (provinsiId == null) {
                toastSimple("Harap pilih Provinsi")
                return false
            }
            if (kotaId == null) {
                toastSimple("Harap pilih Kota")
                return false
            }
            if (kecamatanId == null) {
                toastSimple("Harap pilih Kecamatan")
                return false
            }*/
        }
        return true
    }

    private fun simpan() {
        val reqData = Jadwal(
           // id_kursus = getKursusId(),
           // label = binding.edtLabel.getString(),
           // alamat = binding.edtAlamat.getString(),
            //provinsi = provinsi,

        )
       /* viewModel.create(reqData).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    toastSuccess("Berhasil menambah alamat")
                    onBackPressed()
                }
                State.ERROR -> {
                    progress.dismiss()
                    showErrorDialog(it.message.defaultError())
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        }*/
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}