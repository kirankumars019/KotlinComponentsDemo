package com.mrk.kotlincomponentsdemo.mvvm_repository

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrk.kotlincomponentsdemo.mvvm_repository.adapter.MVVMWithRepositoryAdapter
import com.mrk.kotlincomponentsdemo.mvvm_repository.viewmodel.MVVMWithRepositoryViewModel
import com.mrk.kotlincomponentsdemo.R

class MVVMWithRepositoryActivity : AppCompatActivity() {

    private lateinit var viewmodel: MVVMWithRepositoryViewModel
    private val adapter = MVVMWithRepositoryAdapter()
    private val TAG = "MVVMActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_with_repository_activity)

        val contentListRecyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        contentListRecyclerview.layoutManager = LinearLayoutManager(this)
       // contentListRecyclerview.adapter = MVVMAdapter()
        contentListRecyclerview.adapter = adapter

        viewmodel = ViewModelProvider(this).get(MVVMWithRepositoryViewModel::class.java)

        viewmodel.getAllUserModels()?.observe(this, Observer{
            Log.e(TAG, "getAllUserModels: it $it", )

            if (it != null) {
                adapter.setMovieList(it)
            } else
            {
                Toast.makeText(this, "Error in getting list ", Toast.LENGTH_SHORT).show()
            }
        })

        //Todo: this also works fine
       /* viewmodel.getAllUserModelsNew()
        viewmodel.userModelList?.observe(this, Observer {

            Log.e(TAG, "getAllUserModels: it $it", )

            if (it != null) {
                adapter.setMovieList(it)
            }
        })*/
    }
}