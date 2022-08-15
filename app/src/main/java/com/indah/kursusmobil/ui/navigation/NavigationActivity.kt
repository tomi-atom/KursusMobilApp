package com.indah.kursusmobil.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.indah.kursusmobil.R
import com.indah.kursusmobil.databinding.ActivityNavigationBinding
import com.indah.kursusmobil.ui.auth.LoginActivity
import com.indah.kursusmobil.util.Prefs
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding
    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()
        getUser()
    }

    private fun getUser() {
        viewModel.getUser(Prefs.getUser()?.id ?: 0).observe(this, {})
    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_notifications) {
                if (Prefs.isLogin) { //  true atau false
                    Log.d("TAG", "sudah login")
                    navController.navigate(it.itemId)
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                    Log.d("TAG", "belum login, pindah ke maenu login")
                    return@setOnItemSelectedListener false
                }
            } else {
                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yg lain" + it.itemId)
            }

            return@setOnItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}