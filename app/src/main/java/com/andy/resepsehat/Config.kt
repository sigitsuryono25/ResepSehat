package com.andy.resepsehat

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Config {
    val BASE_URL = "http://andy.lauwba.com"
    fun getOkHtpp(): OkHttpClient {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return okHttpClient
    }

    fun setupRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHtpp())
            .build()
    }

    fun getService(): ApiService {
        return setupRetrofit().create(ApiService::class.java)
    }
}