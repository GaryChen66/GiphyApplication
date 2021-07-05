package com.freshworks.giphy.viewmodels

import androidx.lifecycle.ViewModel
import com.freshworks.giphy.helper.ensureBackgroundThread
import com.freshworks.giphy.repository.GiphyRepository
import com.freshworks.giphy.repository.model.GiphyModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(val giphyRepository: GiphyRepository): ViewModel() {
    val compositeDisposable = CompositeDisposable()

    fun dispose() {
        compositeDisposable.dispose()
    }

    fun insertFavoriteGif(item: GiphyModel) {
        ensureBackgroundThread {
            giphyRepository.insertFavoriteGif(item)
        }
    }

    fun removeFavoriteGif(id: String) {
        ensureBackgroundThread {
            giphyRepository.removeFavoriteGif(id)
        }
    }
}