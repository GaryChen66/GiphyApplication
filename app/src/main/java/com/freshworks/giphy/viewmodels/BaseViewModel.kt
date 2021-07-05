package com.freshworks.giphy.viewmodels

import androidx.lifecycle.ViewModel
import com.freshworks.giphy.repository.GiphyRepository
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(val giphyRepository: GiphyRepository): ViewModel() {
    val compositeDisposable = CompositeDisposable()

    fun dispose() {
        compositeDisposable.dispose()
    }
}