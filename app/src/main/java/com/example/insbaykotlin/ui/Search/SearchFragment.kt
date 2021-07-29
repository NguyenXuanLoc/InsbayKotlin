package com.example.insbaykotlin.ui.Search

import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.ui.Profile.ProfileFragment
import com.example.pview.ui.base.BaseFragment

class SearchFragment : BaseFragment<SearchView, SearchPresenter>(), SearchView {
    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }
    override fun initView(): SearchView {
        return this
    }

    override fun initPresenter(): SearchPresenter {
        return SearchPresenter(ctx!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initWidgets() {
    }

    override fun onSendDataSuccess() {
    }
}