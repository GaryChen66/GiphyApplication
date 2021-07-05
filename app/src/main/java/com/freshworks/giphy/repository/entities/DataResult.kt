package com.freshworks.giphy.repository.entities

class DataResult<T> (
    val data: T? = null,
    val error: Throwable? = null,
)