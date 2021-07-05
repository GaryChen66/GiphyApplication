package com.freshworks.giphy.viewmodels

import androidx.lifecycle.LiveData
import com.freshworks.giphy.repository.GiphyRepository
import com.freshworks.giphy.repository.db.Favorite

class FavoriteViewModel(giphyRepository: GiphyRepository): BaseViewModel(giphyRepository) {
    val favoriteGifs: LiveData<List<Favorite>>
        get() = giphyRepository.getFavoriteGifs()
}