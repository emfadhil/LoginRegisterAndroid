package com.fadhil.loginregisterandroid.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class ConfigNetwork {
    //buat function setelah install plugin OkHttp di gridle
    fun interceptor(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client : OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(logging)
            .build()

        return client
    }
    // end buat function setelah install plugin OkHttp di gridle

    fun configRetrofit(): UserServices{

        val retrofit = Retrofit.Builder()
            .baseUrl("http://sakola.udadeveloper.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(interceptor())
            .build()


        val service = retrofit.create(UserServices::class.java)
        return service


    }
}