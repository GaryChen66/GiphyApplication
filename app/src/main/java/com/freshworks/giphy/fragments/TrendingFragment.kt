package com.freshworks.giphy.fragments

import android.os.Bundle
import android.view.View
import com.freshworks.giphy.repository.model.GiphyModel
import com.freshworks.giphy.viewmodels.TrendingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment: BaseFragment() {
    override val viewModel by viewModel<TrendingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.giphy.observe(viewLifecycleOwner) {
            when {
                it.data != null -> {
                    listAdapter.submitList(it.data)
                }
                it.error != null -> {
                }
            }
        }
        viewModel.favoriteGifs.observe(viewLifecycleOwner) {
            viewModel.loadGifs("")
        }

        //Load giphy data through API
        viewModel.loadGifs("")
    }

    override fun setFavoriteStatus(item: GiphyModel, isFavorite: Boolean) {
        if(isFavorite) {
            viewModel.insertFavoriteGif(item)
        } else {
            viewModel.removeFavoriteGif(item.id)
        }
    }
}