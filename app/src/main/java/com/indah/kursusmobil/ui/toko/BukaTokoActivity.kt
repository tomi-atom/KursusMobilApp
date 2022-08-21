package com.indah.kursusmobil.ui.toko

import android.os.Bundle
import com.indah.kursusmobil.core.data.source.model.Toko
import com.indah.kursusmobil.core.data.source.remote.network.State
import com.indah.kursusmobil.core.data.source.remote.request.CreateTokoRequest
import com.indah.kursusmobil.databinding.ActivityBukaTokoBinding
import com.indah.kursusmobil.ui.base.MyActivity
import com.indah.kursusmobil.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BukaTokoActivity : MyActivity() {

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
        binding.btnBukToko.setOnClickListener {
            bukaToko()
        }
    }

    private fun bukaToko() {
        val body = CreateTokoRequest(
            userId = Prefs.getUser()?.id ?: 0,
            name = binding.edtName.getString(),
            kota = binding.edtLokasi.getString()
        )
        viewModel.createToko(body).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    val data = it.data
                    toastSimple("nama Toko:" + data?.name)
                    intentActivity(TokoSayaActivity::class.java)

                    val user = Prefs.getUser()
                    user?.toko = Toko(
                        id = data?.id,
                        name = data?.name,
                        kota = data?.kota
                    )
                    Prefs.setUser(user)
                    finish()
                }
                State.ERROR -> {
                    progress.dismiss()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}