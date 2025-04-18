package com.richuff.rcclient.core.network.di

import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object NetWorkModule {
    fun providerJson(): Json  =  Json {
            ignoreUnknownKeys = true // 忽略未知键
    }
    fun okhttpFactory(okHttpClient: OkHttpClient): Call.Factory = okHttpClient

    fun providesOkhttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS) //连接超时时间
            .writeTimeout(10, TimeUnit.SECONDS)  //写连接超时时间
            .readTimeout(10, TimeUnit.SECONDS)  //读连接超时时间
            .build()
    }
}