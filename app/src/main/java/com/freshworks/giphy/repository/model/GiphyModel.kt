package com.freshworks.giphy.repository.model

import com.freshworks.giphy.repository.db.Favorite

data class GiphyModel (val id: String, val title: String, val path: String, val isFavorite: Boolean) {
    constructor(item: Favorite): this(item.giphyId, item.title, item.path, true)
}