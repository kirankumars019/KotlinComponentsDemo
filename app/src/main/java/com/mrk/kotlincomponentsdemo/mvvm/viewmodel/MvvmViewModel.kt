package com.mrk.kotlincomponentsdemo.mvvm.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrk.kotlincomponentsdemo.mvvm.service.MvvmRetrofitClientObject
import com.mrk.kotlincomponentsdemo.mvvm.service.MvvmRetrofitInterfcae
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MvvmViewModel : ViewModel() {

    private var apiRetrofit: MvvmRetrofitInterfcae? = null
    private val TAG = "MvvmViewModel"


    fun getData(context: Context): MutableLiveData<List<UserModel.Data>?> {

        apiRetrofit = MvvmRetrofitClientObject.getRetroInstance()?.create(MvvmRetrofitInterfcae::class.java)

        val liveData: MutableLiveData<List<UserModel.Data>?> =
            MutableLiveData<List<UserModel.Data>?>()


        apiRetrofit?.getData()?.enqueue(object : Callback<UserModel?> {
            override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {

                Log.d(TAG, "onResponse response:: $response")
                val body = response.body()
                liveData.postValue(body?.data)
            }

            override fun onFailure(call: Call<UserModel?>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
                liveData.postValue(null)
            }
        })
        return liveData
    }
}