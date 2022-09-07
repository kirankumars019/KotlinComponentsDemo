package com.mrk.kotlincomponentsdemo.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrk.kotlincomponentsdemo.R
import com.mrk.kotlincomponentsdemo.databinding.ActivityApiCallBinding
import com.mrk.kotlincomponentsdemo.retrofit.ViewModel.RetrofitViewModel
import com.mrk.kotlincomponentsdemo.retrofit.adapter.UserAdapter
import com.mrk.kotlincomponentsdemo.retrofit.apicall.ApiInterface
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import javax.security.auth.callback.Callback

class RetrofitApiCallActivity : AppCompatActivity() {

    lateinit var viewmodel : RetrofitViewModel
    lateinit var  binding: ActivityApiCallBinding
    private val articleArrayList: ArrayList<UserModel> = ArrayList()
    private val TAG = "RetrofitViewModel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_api_call)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_api_call)

        viewmodel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        viewmodel.getUsers()?.observe(this, Observer { userModel->

            Log.e(TAG, "onCreate: userModel $userModel", )
            
            binding.recyclerview.layoutManager = LinearLayoutManager(this )

            if (userModel != null) {
                articleArrayList.add(userModel)
            }
            binding.recyclerview.adapter = UserAdapter(userModel, articleArrayList)
        })
        //apiCall()
    }

   /* private fun apiCall() {
        val apiInterface = ApiInterface.create().getMovies()

        apiInterface.enqueue(object : Callback<>){
        }
    }*/


}