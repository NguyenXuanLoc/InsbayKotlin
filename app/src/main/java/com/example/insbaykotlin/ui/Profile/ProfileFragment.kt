package com.example.insbaykotlin.ui.Profile

import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.pview.ui.base.BaseFragment

class ProfileFragment : BaseFragment<ProfileView, ProfilePresenter>(), ProfileView {
    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun initView(): ProfileView {
        return this
    }

    override fun initPresenter(): ProfilePresenter {
        return ProfilePresenter(ctx!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initWidgets() {
    }

    override fun onSendDataSuccess() {
    }
}