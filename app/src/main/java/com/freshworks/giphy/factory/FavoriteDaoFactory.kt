package com.freshworks.giphy.factory

import com.freshworks.giphy.repository.db.GiphyDb

object FavoriteDaoFactory {
    fun create(db: GiphyDb) = db.favoriteDao()
}