package com.freshworks.giphy.fragments

import com.freshworks.giphy.viewmodels.TrendingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment: BaseFragment() {
    override val viewModel by viewModel<TrendingViewModel>()
}