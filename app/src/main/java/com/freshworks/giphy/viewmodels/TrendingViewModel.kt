package com.freshworks.giphy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.freshworks.giphy.helper.GiphyModelList
import com.freshworks.giphy.repository.GiphyRepository
import com.freshworks.giphy.repository.entities.DataResult
import com.freshworks.giphy.repository.model.GiphyModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TrendingViewModel(giphyRepository: GiphyRepository): BaseViewModel(giphyRepository) {
    private val _giphy = MutableLiveData<DataResult<GiphyModelList>>()
    val giphy: LiveData<DataResult<GiphyModelList>>
        get() = _giphy

    fun loadGifs(query: String) {
        _giphy.postValue(DataResult(null, null))

        compositeDisposable.add(
            giphyRepository.searchGifs(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { it ->
                        _giphy.postValue(DataResult(it.giphyList.map { GiphyModel(it.id, it.title, it.images.fixedHeight.url, it.isFavorite) }, null))
                    },
                    {
                        _giphy.postValue(DataResult(null, it))
                    }
                )
        )
    }
}