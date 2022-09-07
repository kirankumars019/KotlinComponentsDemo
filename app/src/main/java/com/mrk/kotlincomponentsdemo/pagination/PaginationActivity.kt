package com.mrk.kotlincomponentsdemo.pagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrk.kotlincomponentsdemo.R
import com.mrk.kotlincomponentsdemo.databinding.ActivityPaginationBinding
import com.mrk.kotlincomponentsdemo.pagination.adapter.PagingAdapter
import com.mrk.kotlincomponentsdemo.pagination.repository.PaginationRepository
import com.mrk.kotlincomponentsdemo.pagination.service.PaginationApi
import com.mrk.kotlincomponentsdemo.pagination.viewmodel.PaginationViewModelFactory
import com.mrk.kotlincomponentsdemo.pagination.viewmodel.PaginationViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PaginationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaginationBinding
    private lateinit var viewmodel: PaginationViewmodel
    private var adapter = PagingAdapter()
    private val TAG = "PaginationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pagination)

        val retrofirService = PaginationApi.getInstance()
        val repository = PaginationRepository(retrofirService)


        viewmodel = ViewModelProvider(
            this,
            PaginationViewModelFactory(repository)
        ).get(PaginationViewmodel::class.java)

        binding.paginationRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.paginationRecyclerview.adapter = adapter

        lifecycleScope.launch {

            viewmodel.getPagingData().observe(this@PaginationActivity) {
                it?.let {

                    Log.e(TAG, "getPagingDat: called $it")
                    adapter.submitData(lifecycle, it)
                }
            }
        }

    }
}