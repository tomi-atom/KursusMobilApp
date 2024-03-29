package com.indah.kursusmobil.ui.akun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.indah.kursusmobil.ui.navigation.NavigationActivity
import com.indah.kursusmobil.databinding.FragmentAkunBinding
import com.indah.kursusmobil.ui.jadwal.ListJadwalActivity
import com.indah.kursusmobil.ui.kursus.DaftarKursusActivity
import com.indah.kursusmobil.ui.kursus.KursusSayaActivity
import com.indah.kursusmobil.ui.updateProfile.UpdateProfileActivity
import com.indah.kursusmobil.util.Constants.USER_URL
import com.indah.kursusmobil.util.Prefs
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.toGone
import com.squareup.picasso.Picasso

class AkunFragment : Fragment() {

    private lateinit var notificationsViewModel: AkunViewModel
    private var _binding: FragmentAkunBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        notificationsViewModel = ViewModelProvider(this).get(AkunViewModel::class.java)

        _binding = FragmentAkunBinding.inflate(inflater, container, false)
        val root: View = binding.root


        mainButton()
        return root
    }

    override fun onResume() {
        setUser()
        super.onResume()
    }

    private fun mainButton() {
        binding.btnLogout.setOnClickListener {
            Prefs.isLogin = false
            pushActivity(NavigationActivity::class.java)
        }

        binding.btnUpdate.setOnClickListener {
            intentActivity(UpdateProfileActivity::class.java)
        }


    }


    private fun setUser() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                tvName.text = user.name
                tvEmail.text = user.email
                tvPhone.text = user.phone_number
                tvPhone.text = user.phone_number
                tvInisial.text = user.name.getInitial()

                Picasso.get().load(USER_URL + user.image).into(binding.imageProfile)

                if (user.kursus != null) {
                    tvStatusToko.toGone()
                    tvNameToko.text = user.kursus?.status
                    binding.btnToko.setOnClickListener {
                        intentActivity(KursusSayaActivity::class.java)
                    }
                } else {
                    binding.btnToko.setOnClickListener {
                        intentActivity(DaftarKursusActivity::class.java)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}