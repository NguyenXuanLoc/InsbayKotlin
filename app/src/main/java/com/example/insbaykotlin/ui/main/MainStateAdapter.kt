package com.example.insbaykotlin.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.insbaykotlin.ui.Profile.ProfileFragment
import com.example.insbaykotlin.ui.Search.SearchFragment
import com.example.insbaykotlin.ui.camera.CameraFragment
import com.example.insbaykotlin.ui.home.HomeFragment

class MainStateAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val pager by lazy {
        arrayListOf(
            HomeFragment.newInstance(),
            SearchFragment.newInstance(),
            CameraFragment.newInstance(),
            ProfileFragment.newInstance()
        )
    }

    override fun getItemCount(): Int {
        return pager.size
    }

    override fun createFragment(position: Int): Fragment {
        return pager[position]
    }
}