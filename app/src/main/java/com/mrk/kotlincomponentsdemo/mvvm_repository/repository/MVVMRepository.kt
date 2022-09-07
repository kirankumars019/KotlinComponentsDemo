package com.mrk.kotlincomponentsdemo.mvvm_repository.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mrk.kotlincomponentsdemo.mvvm_repository.service.MVVMRetrofitApi
import com.mrk.kotlincomponentsdemo.retrofit.apicall.ApiInterface
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MVVMRepository
//constructor(private val mvvmRetrofitService: MVVMRetrofitService)
{

    private var apiRequest: MVVMRetrofitApi? = null
    private val TAG = "MVVMRepository"

    companion object {
        private var repository: MVVMRepository? = null
        fun getInstance(): MVVMRepository {
            if (repository == null) {
                repository = MVVMRepository()
            }
            return repository!!
        }
    }


    fun getAllMovies(): MutableLiveData<List<UserModel.Data>?> {

        apiRequest = ApiInterface.getRetrofitInstance()?.create(MVVMRetrofitApi::class.java)

        val data: MutableLiveData<List<UserModel.Data>?> = MutableLiveData<List<UserModel.Data>?>()

        apiRequest?.getAllMovies()
            ?.enqueue(object : Callback<UserModel?> {
                override fun onResponse(
                    call: Call<UserModel?>?,
                    response: Response<UserModel?>
                ) {
                    Log.d(TAG, "onResponse response:: $response")
                    if (response.body() != null) {
                        val responseBody = response.body()
                        data.setValue(responseBody?.data)
                        Log.d(TAG, "articles total result:: " + response.body())
                    }
                }

                override fun onFailure(call: Call<UserModel?>?, t: Throwable?) {
                    data.setValue(null)
                }
            })
        return data
    }


}