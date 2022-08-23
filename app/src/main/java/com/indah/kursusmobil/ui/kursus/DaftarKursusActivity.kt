package com.indah.kursusmobil.ui.kursus

import android.os.Bundle
import com.indah.kursusmobil.core.data.source.model.Kursus
import com.indah.kursusmobil.core.data.source.model.Toko
import com.indah.kursusmobil.core.data.source.remote.network.State
import com.indah.kursusmobil.core.data.source.remote.request.CreateKursusRequest
import com.indah.kursusmobil.databinding.ActivityBukaKursusBinding
import com.indah.kursusmobil.ui.base.MyActivity
import com.indah.kursusmobil.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DaftarKursusActivity : MyActivity() {

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
        binding.btnBukToko.setOnClickListener {
            bukaToko()
        }
    }

    private fun bukaToko() {
        val body = CreateKursusRequest(
            userId = Prefs.getUser()?.id ?: 0,
            name = binding.edtName.getString(),
            kota = binding.edtLokasi.getString(),


        )
        viewModel.createToko(body).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    val data = it.data
                    toastSimple("n:" + data?.name)
                    intentActivity(KursusSayaActivity::class.java)

                    val user = Prefs.getUser()

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