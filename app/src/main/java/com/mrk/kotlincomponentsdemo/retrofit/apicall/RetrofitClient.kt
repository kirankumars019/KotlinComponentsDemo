package com.mrk.kotlincomponentsdemo.retrofit.apicall

import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitClient {


    /*Retrofit provides the list of annotations for each HTTP method:
    @GET, @POST, @PUT, @DELETE, @PATCH, or @HEAD.*/


  /*  Method Parameters :
    @Body — Sends Java objects as the request body.

    @Url — use dynamic URLs.

    @Query — We can simply add a method parameter with @Query() and a query parameter name, describing the type.*/

    //@Headers("Content-type: application/json")
    @GET("api/users?page=2")
    fun getUser(): Call<UserModel>

}