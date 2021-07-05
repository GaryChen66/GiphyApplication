package com.freshworks.giphy.repository.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class Response {
    @JsonClass(generateAdapter = true)
    class GiphyData(
        @Json(name = "data") val giphyList: List<Giphy>
    )

    @JsonClass(generateAdapter = true)
    class Giphy(
        @Json(name = "id") val id: String,
        @Json(name = "title") val title: String,
        @Json(name = "images") val images: Images
    )

    @JsonClass(generateAdapter = true)
    class Images(
        @Json(name = "fixed_height") val fixedHeight: Image
    )

    @JsonClass(generateAdapter = true)
    class Image(
        @Json(name = "url") val url: String
    )
}