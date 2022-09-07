package com.mrk.kotlincomponentsdemo.retrofit.apicall

import com.mrk.kotlincomponentsdemo.application.Urls
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterface {

  /*  private val client = OkHttpClient.Builder().build()

    fun create(): ApiInterface {
         val retrofit = Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
*/

    private var retrofit: Retrofit? = null

    //Create the Retrofit service instance using the retrofit.
    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }



}