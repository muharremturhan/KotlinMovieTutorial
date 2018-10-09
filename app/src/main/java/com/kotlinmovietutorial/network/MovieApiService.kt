package com.kotlinmovietutorial.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MovieApiService {

    private var ourInstance:Retrofit?=null
    val  instance:Retrofit
        get() {
            if(ourInstance == null){
                ourInstance = createRetrofitInstance(Constants.BASE_URL)
            }

            return ourInstance!!
        }
    private fun createRetrofitInstance(url: String):Retrofit{
        return  Retrofit.Builder().baseUrl(url)
                .client(provideOkhttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    private fun provideOkhttpClient():OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(Constants.TIME_OUT,TimeUnit.SECONDS)
        okHttpClient.readTimeout(Constants.TIME_OUT,TimeUnit.SECONDS)
        okHttpClient.addInterceptor(RequestInterceptor())
        return okHttpClient.build()
    }
}