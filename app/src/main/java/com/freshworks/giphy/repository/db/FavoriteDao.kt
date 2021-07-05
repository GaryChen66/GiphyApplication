package com.freshworks.giphy.repository.db

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single

@Dao
interface FavoriteDao {
    @Query("SELECT giphyId FROM favorites_tb")
    fun getAllFavIds() : Single<List<String>>
}