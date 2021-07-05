package com.freshworks.giphy.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.freshworks.giphy.fragments.FavoriteFragment
import com.freshworks.giphy.fragments.TrendingFragment

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int) = if(position == 0) TrendingFragment() else FavoriteFragment()
}