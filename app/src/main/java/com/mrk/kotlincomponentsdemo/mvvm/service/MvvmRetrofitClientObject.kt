package com.mrk.kotlincomponentsdemo.mvvm.service

import com.mrk.kotlincomponentsdemo.application.Urls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MvvmRetrofitClientObject {

    var retrofit: Retrofit? = null

    fun getRetroInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit =
                Retrofit.Builder()
                    .baseUrl(Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        }
        return retrofit
    }

}