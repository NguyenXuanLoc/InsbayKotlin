package com.example.insbaykotlin.ui.home

import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.common.ext.setImage
import com.example.pview.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

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
        sdvTest.setImage("https://insbay-file.s3.eu-central-1.amazonaws.com/uploads/5428/album-49e4ee6d-b47d-44ef-86d0-3fd60e231b10/8875e819-89eb-4927-803e-48d77fccb4a1-azienka1.thumbnail.100x100.jpg")
    }

    override fun onSendDataSuccess() {
    }
}