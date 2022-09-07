package com.mrk.kotlincomponentsdemo.retrofit.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import com.mrk.kotlincomponentsdemo.retrofit.repository.RetrofitRepository

class RetrofitViewModel: ViewModel() {

    var userLiveData: MutableLiveData<UserModel?>? = null
    private val TAG = "RetrofitViewModel"
    private val articleRepository: RetrofitRepository? = null


    fun getUsers(): MutableLiveData<UserModel?>? {


        userLiveData = RetrofitRepository.getUsers()

        Log.e(TAG, "getUsers: $userLiveData")
        return userLiveData
    }
}