package com.freshworks.giphy.factory

import com.squareup.moshi.Moshi

object MoshiFactory {
    fun create(): Moshi = Moshi.Builder().build()
}