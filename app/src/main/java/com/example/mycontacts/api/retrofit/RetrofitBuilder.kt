package com.example.mycontacts.api.retrofit

import com.example.mycontacts.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {

    fun retrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient.build())
            .build()
    }

}