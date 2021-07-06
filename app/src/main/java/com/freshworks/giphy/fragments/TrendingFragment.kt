package com.freshworks.giphy.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import com.freshworks.giphy.R
import com.freshworks.giphy.repository.model.GiphyModel
import com.freshworks.giphy.viewmodels.TrendingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment to show trending gifs
 * @see BaseFragment
 */
class TrendingFragment: BaseFragment() {
    override val viewModel by viewModel<TrendingViewModel>()
    var query: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

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
            viewModel.loadGifs(query)
        }

        //Load giphy data through API
        viewModel.initLoading()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)

        val searchItem = menu.findItem(R.id.search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = getString(R.string.search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(query != newText) {
                    query = newText ?: ""
                    viewModel.loadGifs(query)
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun setFavoriteStatus(item: GiphyModel, isFavorite: Boolean) {
        if(isFavorite) {
            viewModel.insertFavoriteGif(item)
        } else {
            viewModel.removeFavoriteGif(item.id)
        }
    }
}