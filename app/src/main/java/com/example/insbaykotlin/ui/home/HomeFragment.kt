package com.example.insbaykotlin.ui.home

import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.ui.Search.SearchFragment
import com.example.pview.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun initView(): HomeView {
        return this
    }

    override fun initPresenter(): HomePresenter {
        return HomePresenter(ctx!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initWidgets() {
    }

    override fun onSendDataSuccess() {
    }
}