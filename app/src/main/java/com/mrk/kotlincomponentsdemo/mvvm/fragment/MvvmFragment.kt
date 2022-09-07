package com.mrk.kotlincomponentsdemo.mvvm.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrk.kotlincomponentsdemo.databinding.FragmentMvvmBinding
import com.mrk.kotlincomponentsdemo.mvvm.adapter.MvvmAdapter
import com.mrk.kotlincomponentsdemo.mvvm.viewmodel.MvvmViewModel
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class MvvmFragment : Fragment(){

    private lateinit var binding: FragmentMvvmBinding
    private lateinit var viewModel: MvvmViewModel
    private val TAG = "MvvmFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMvvmBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(MvvmViewModel::class.java)
        apicall()


        return binding.root
    }

    private fun apicall() {

        viewModel.getData(requireContext()).observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "apicall: $it", )
            setRecycler(it)
        })
    }

    private fun setRecycler(model: List<UserModel.Data>?) {
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MvvmAdapter(model)
    }
}