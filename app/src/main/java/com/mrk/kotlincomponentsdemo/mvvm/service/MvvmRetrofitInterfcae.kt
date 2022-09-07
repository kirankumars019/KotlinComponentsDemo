package com.mrk.kotlincomponentsdemo.mvvm.service

import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface MvvmRetrofitInterfcae {

    @GET("api/users?page=2")
    fun getData(): Call<UserModel>
}