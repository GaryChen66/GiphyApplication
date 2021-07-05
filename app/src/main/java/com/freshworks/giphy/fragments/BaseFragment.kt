package com.freshworks.giphy.fragments

import androidx.fragment.app.Fragment
import com.freshworks.giphy.R
import com.freshworks.giphy.viewmodels.BaseViewModel

abstract class BaseFragment: Fragment(R.layout.fragment_main) {
    abstract val viewModel: BaseViewModel
}