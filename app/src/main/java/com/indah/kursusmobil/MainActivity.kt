package com.indah.kursusmobil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.indah.kursusmobil.R.layout.activity_main)

        Log.d("RESPOM", "PESAN SINGKAT")


        // get data dari server
    }
}