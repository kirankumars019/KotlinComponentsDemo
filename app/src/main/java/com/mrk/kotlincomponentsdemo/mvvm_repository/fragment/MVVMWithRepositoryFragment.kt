package com.mrk.kotlincomponentsdemo.mvvm_repository.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrk.kotlincomponentsdemo.mvvm_repository.adapter.MVVMWithRepositoryAdapter
import com.mrk.kotlincomponentsdemo.R
import com.mrk.kotlincomponentsdemo.databinding.FragmentMvvmWithRepositoryBinding

class MVVMWithRepositoryFragment : Fragment() {

    private lateinit var binding: FragmentMvvmWithRepositoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mvvm_with_repository, container, false)

        setUpUi()

        return binding.root
    }

    private fun setUpUi() {
        binding.mvvmRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.mvvmRecyclerview.adapter =MVVMWithRepositoryAdapter()
    }

}