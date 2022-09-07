package com.mrk.kotlincomponentsdemo.mvvm_repository.service

import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface MVVMRetrofitApi {

    @GET("api/users?page=2")
    fun getAllMovies(): Call<UserModel>

}