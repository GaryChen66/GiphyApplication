package com.freshworks.giphy.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Favorite::class],
    version = 10
)
abstract class GiphyDb: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}