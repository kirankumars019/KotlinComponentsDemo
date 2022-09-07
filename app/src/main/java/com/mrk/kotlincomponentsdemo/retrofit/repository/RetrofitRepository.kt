package com.mrk.kotlincomponentsdemo.retrofit.repository


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mrk.kotlincomponentsdemo.retrofit.apicall.ApiInterface
import com.mrk.kotlincomponentsdemo.retrofit.apicall.RetrofitClient
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RetrofitRepository {

    val userLivedata = MutableLiveData<UserModel>()
    private val TAG = "RetrofitRepository"

    private var apiRequest: RetrofitClient? = null

    fun ArticleRepository() {
        apiRequest = ApiInterface.getRetrofitInstance()?.create(RetrofitClient::class.java)
    }


    fun getUsers(): MutableLiveData<UserModel?> {

        apiRequest = ApiInterface.getRetrofitInstance()?.create(RetrofitClient::class.java)

        val data: MutableLiveData<UserModel?> = MutableLiveData<UserModel?>()
        apiRequest?.getUser()
            ?.enqueue(object : Callback<UserModel?> {
                override fun onResponse(
                    call: Call<UserModel?>?,
                    response: Response<UserModel?>
                ) {
                    Log.d(TAG, "onResponse response:: $response")
                    if (response.body() != null) {
                        data.setValue(response.body())
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