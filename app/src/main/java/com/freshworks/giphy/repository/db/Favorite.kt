package com.freshworks.giphy.repository.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_tb")
data class Favorite (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    var giphyId: String,
    var title: String,
    var path: String
)