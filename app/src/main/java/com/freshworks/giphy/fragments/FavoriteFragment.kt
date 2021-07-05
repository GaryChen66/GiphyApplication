package com.freshworks.giphy.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.freshworks.giphy.R
import com.freshworks.giphy.repository.model.GiphyModel
import com.freshworks.giphy.viewmodels.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment to show favorite gifs
 * @see BaseFragment
 */
class FavoriteFragment: BaseFragment() {
    override val viewModel by viewModel<FavoriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.favoriteGifs.observe(viewLifecycleOwner) {
            listAdapter.submitList(it.map(::GiphyModel))

            //Show `empty` view if there is no favorite gif
            if(it.isEmpty()) {
                binding.giphyList.isVisible = false
                binding.noGif.isVisible = true
            } else {
                binding.giphyList.isVisible = true
                binding.noGif.isVisible = false
            }
        }

        binding.noGif.text = getString(R.string.no_favorite)
    }

    override fun setFavoriteStatus(item:GiphyModel, isFavorite: Boolean) {
        //Always remove from favorite
        viewModel.removeFavoriteGif(item.id)
    }
}