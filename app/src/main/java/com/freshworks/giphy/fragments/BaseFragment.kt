package com.freshworks.giphy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.freshworks.giphy.R
import com.freshworks.giphy.adapters.GiphyItemListAdapter
import com.freshworks.giphy.databinding.FragmentMainBinding
import com.freshworks.giphy.repository.model.GiphyModel
import com.freshworks.giphy.viewmodels.BaseViewModel

abstract class BaseFragment: Fragment(R.layout.fragment_main) {
    abstract val viewModel: BaseViewModel

    private lateinit var _binding: FragmentMainBinding

    private var _listAdapter =  GiphyItemListAdapter(::setFavoriteStatus)
    val listAdapter get() = _listAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.giphyList.apply {
            adapter = _listAdapter
        }
    }

    abstract fun setFavoriteStatus(item: GiphyModel, isFavorite: Boolean)
}