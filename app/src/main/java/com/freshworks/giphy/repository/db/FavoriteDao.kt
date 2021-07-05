package com.freshworks.giphy.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface FavoriteDao {
    @Query("SELECT giphyId FROM favorites_tb")
    fun getAllFavIds() : Single<List<String>>

    @Query("SELECT * FROM favorites_tb")
    fun getFavoriteGifs() : LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteEntity: Favorite)

    @Query("DELETE FROM favorites_tb WHERE giphyId = :id")
    fun delete(id: String)
}