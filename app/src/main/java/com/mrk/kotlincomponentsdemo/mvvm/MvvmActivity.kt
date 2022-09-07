package com.mrk.kotlincomponentsdemo.mvvm

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mrk.kotlincomponentsdemo.R
import com.mrk.kotlincomponentsdemo.databinding.ActivityMvvmBinding
import com.mrk.kotlincomponentsdemo.mvvm.fragment.MvvmFragment

class MvvmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.mvvm_container, MvvmFragment()).commit()
        }
    }
}