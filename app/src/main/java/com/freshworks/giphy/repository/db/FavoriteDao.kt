package com.freshworks.giphy.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single

@Dao
interface FavoriteDao {
    @Query("SELECT giphyId FROM favorites_tb")
    fun getAllFavIds() : Single<List<String>>

    @Query("SELECT * FROM favorites_tb")
    fun getFavoriteGifs() : LiveData<List<Favorite>>
}