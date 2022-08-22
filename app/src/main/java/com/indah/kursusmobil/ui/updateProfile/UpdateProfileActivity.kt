package com.indah.kursusmobil.ui.updateProfile

import android.app.Activity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.github.drjacky.imagepicker.ImagePicker
import com.indah.kursusmobil.core.data.source.remote.network.State
import com.indah.kursusmobil.core.data.source.remote.request.UpdateProfileRequest
import com.indah.kursusmobil.databinding.ActivityUpdateProfileBinding
import com.indah.kursusmobil.ui.auth.AuthViewModel
import com.indah.kursusmobil.ui.base.MyActivity
import com.indah.kursusmobil.util.Constants
import com.indah.kursusmobil.util.Prefs
import com.inyongtisto.myhelper.extension.*
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class UpdateProfileActivity : MyActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityUpdateProfileBinding? = null
    private val binding get() = _binding!!
    private var fileImage: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar, "Update Profile")

        mainButton()
        setData()
    }

    private fun setData() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                edtName.setText(user.name)
                edtEmail.setText(user.email)
                edtPhone.setText(user.phone_number)
                edtTanggalLahir.setText(user.birth_date)
                edtAlamat.setText(user.address)
                tvInisial.text = user.name.getInitial()
                Picasso.get().load(Constants.USER_URL + user.image).into(binding.imageProfile)
            }
        }
    }

    private fun mainButton() {
        binding.btnSimpan.setOnClickListener {
            if (fileImage != null) {
                upload()
            } else {
                update()
            }
        }

        binding.imageProfile.setOnClickListener {
            picImage()
        }
    }

    private fun picImage() {
        ImagePicker.with(this)
                .crop()
                .maxResultSize(1080, 1080, true)
                .createIntentFromDialog { launcher.launch(it) }
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val uri = it.data?.data!!

            // Use the uri to load the image
            fileImage = File(uri.path!!)
            Picasso.get().load(fileImage!!).into(binding.imageProfile)
        }
    }

    private fun update() {

        if (binding.edtName.isEmpty()) return
        if (binding.edtPhone.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return

        val idUser = Prefs.getUser()?.id
        val body = UpdateProfileRequest(
                idUser.int(),
                phone_number = binding.edtPhone.text.toString(),
                email = binding.edtEmail.text.toString(),
                name = binding.edtName.text.toString(),
                birth_date = binding.edtTanggalLahir.text.toString(),
                address = binding.edtAlamat.text.toString()
        )

        viewModel.updateUser(body).observe(this, {

            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    showToast("Selamat datang " + it.data?.name)
                    onBackPressed()
                }
                State.ERROR -> {
                    progress.dismiss()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        })
    }

    private fun upload() {
        val idUser = Prefs.getUser()?.id
        val file = fileImage.toMultipartBody()

        viewModel.uploadUser(idUser, file).observe(this, {
            when (it.state) {
                State.SUCCESS -> {
                    update()
                }
                State.ERROR -> {
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}