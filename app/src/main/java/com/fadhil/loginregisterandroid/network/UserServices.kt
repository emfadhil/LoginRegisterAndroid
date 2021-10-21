package com.fadhil.loginregisterandroid.network

import com.fadhil.loginregisterandroid.model.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserServices {


//    @GET("register/{id}") kalo @GET dan mau kasih parameter
//    fun register(
//        @Query//pakainya ini

        @FormUrlEncoded//jika pakai @POST harus sisipkan ini
        @POST("register")
        fun register(
            @Field("name") name : String,
            @Field("email") email : String,
            @Field("password") password : String,
            @Field("school_name") schoolname : String,
            @Field("phone") phone : String

        ): Call<ResponseRegister>

}