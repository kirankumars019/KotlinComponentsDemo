package com.mrk.kotlincomponentsdemo.mvvm_repository.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MVVMRetrofitService {

/*    @GET("api/users?page=2")
    fun getAllMovies() : Call<List<UserModel>>*/

    /*companion object{


    }*/


    var retrofitservice : MVVMRetrofitService? = null

    //Create the Retrofit service instance using the retrofit.
    fun getInsatnce(): MVVMRetrofitService {
        if (retrofitservice == null){
            val retrofit  = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofitservice = retrofit.create(MVVMRetrofitService::class.java)
        }
        return retrofitservice!!
    }
}