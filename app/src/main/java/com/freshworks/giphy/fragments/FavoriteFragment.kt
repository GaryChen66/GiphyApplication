package com.freshworks.giphy.fragments

import com.freshworks.giphy.repository.model.GiphyModel
import com.freshworks.giphy.viewmodels.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment: BaseFragment() {
    override val viewModel by viewModel<FavoriteViewModel>()

    override fun setFavoriteStatus(item: GiphyModel, isFavorite: Boolean) {

    }
}