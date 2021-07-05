package com.freshworks.giphy.factory

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientFactory {
    fun create() = OkHttpClient.Builder()
        .readTimeout(10L, TimeUnit.SECONDS)
        .connectTimeout(15L, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()
}