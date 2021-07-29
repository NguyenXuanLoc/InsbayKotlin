package com.example.insbaykotlin.ui.main

import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.gone
import com.example.task.ui.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.ctx

private const val HOME_INDEX = 0
private const val SEARCH_INDEX = 1
private const val CAMERA_INDEX = 2
private const val PROFILE_INDEX = 3

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView,
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun initView(): MainView {
        return this
    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(ctx)
    }

    override fun getLayoutId(): Int? {
        return R.layout.activity_main
    }

    override fun initWidgets() {
        vpMain.adapter = MainStateAdapter(self)
        vpMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vpMain.isUserInputEnabled = false
        vpMain.currentItem = SEARCH_INDEX
        bnvMain.setOnNavigationItemSelectedListener(this)
        toolbarBase.gone()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                vpMain.currentItem = HOME_INDEX
            }
            R.id.menu_camera -> {
                vpMain.currentItem = CAMERA_INDEX
            }
            R.id.menu_search -> {
                vpMain.currentItem = SEARCH_INDEX
            }
            R.id.menu_profile -> {
                vpMain.currentItem = PROFILE_INDEX
            }
        }
        return true
    }
}