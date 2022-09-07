package com.mrk.kotlincomponentsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mrk.kotlincomponentsdemo.mvvm_repository.MVVMWithRepositoryActivity
import com.mrk.kotlincomponentsdemo.databinding.ActivityMainBinding
import com.mrk.kotlincomponentsdemo.mvvm.MvvmActivity
import com.mrk.kotlincomponentsdemo.pagination.PaginationActivity
import com.mrk.kotlincomponentsdemo.retrofit.RetrofitApiCallActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        buttonClick()
    }

    private fun buttonClick() {

        binding.btnRetrofit.setOnClickListener {
            val intent = Intent(this, RetrofitApiCallActivity::class.java)
            startActivity(intent)
        }

        binding.btnMvvmWithRepository.setOnClickListener {
            val intent = Intent(this, MVVMWithRepositoryActivity::class.java)
            startActivity(intent)
        }

        binding.btnMvvm.setOnClickListener {
            val intent = Intent(this, MvvmActivity::class.java)
            startActivity(intent)
        }

        binding.btnPaginationMvvm.setOnClickListener {
            val intent = Intent(this, PaginationActivity::class.java)
            startActivity(intent)
        }
    }
}