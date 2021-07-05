package com.freshworks.giphy.factory

import com.freshworks.giphy.repository.api.GiphyAPI
import retrofit2.Retrofit

object GiphyApiFactory {
    fun create(retrofit: Retrofit): GiphyAPI = retrofit.create(GiphyAPI::class.java)
}