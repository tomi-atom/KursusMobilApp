package com.indah.kursusmobil.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.indah.kursusmobil.databinding.FragmentHomeBinding
import com.indah.kursusmobil.ui.home.adapter.KursusAdapter

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapterKursus = KursusAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdapter()
        setData()
        mainButton()
        return root
    }

    private fun setupAdapter() {
        binding.rvKursus.adapter = adapterKursus

    }

    private fun setData() {
        viewModel.listKursus.observe(requireActivity(), {
            adapterKursus.addItems(it)
        })


    }

    fun mainButton() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}