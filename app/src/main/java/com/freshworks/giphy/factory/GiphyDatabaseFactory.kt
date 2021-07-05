package com.freshworks.giphy.factory

import android.content.Context
import androidx.room.Room
import com.freshworks.giphy.helper.DB_FILE
import com.freshworks.giphy.repository.db.GiphyDb

object GiphyDatabaseFactory {
    fun create(context: Context) =
        Room.databaseBuilder(
            context.applicationContext, GiphyDb::class.java, DB_FILE
        ).fallbackToDestructiveMigration().build()
}