package com.mrk.kotlincomponentsdemo.pagination.service

import com.mrk.kotlincomponentsdemo.pagination.model.JsonResponce
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PaginationApi {

   // @GET("api/users?page=2")
 /*   @GET("api/users")
    fun getPagingData(@Path("page") page: Int, @Path("size") size: Int): Response<UserModel>*/

    @GET("gate/b2b/test/catalog/api/v1/category/getAllCategoriesByCatalogueWithoutlogin")
    suspend fun getPagingData(@Query("page") page :Int ,@Query("size") size :Int, @Query("catalogue") catalog: String): Response<JsonResponce>

    companion object{
        var retrofitService: PaginationApi? = null
        val BASE_URl = "https://server.mrkzevar.com/"
     //   val BASE_URl = "https://reqres.in/"


        fun getInstance(): PaginationApi {
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(PaginationApi::class.java)
            }
            return retrofitService!!
        }
    }
}
