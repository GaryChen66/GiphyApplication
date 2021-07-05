package com.freshworks.giphy.repository.api

import com.freshworks.giphy.helper.API_KEY
import com.freshworks.giphy.helper.LIMIT
import com.freshworks.giphy.helper.OFFSET
import com.freshworks.giphy.repository.entities.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyAPI {
    @GET("trending")
    fun getTrendingGifs(
        @Query("limit") limit: Int = LIMIT,
        @Query("offset") offset: Int = OFFSET,
        @Query("api_key") apiKey: String = API_KEY
    ): Single<Response.GiphyData>

    @GET("search")
    fun searchGifs(
        @Query("limit") limit: Int = LIMIT,
        @Query("offset") offset: Int = OFFSET,
        @Query("q") query: String,
        @Query("api_key") apiKey: String = API_KEY
    ): Single<Response.GiphyData>
}