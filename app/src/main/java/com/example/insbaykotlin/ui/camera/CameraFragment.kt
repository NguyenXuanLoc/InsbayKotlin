package com.example.insbaykotlin.ui.camera

import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.pview.ui.base.BaseFragment

class CameraFragment : BaseFragment<CameraView, CameraPresenter>(), CameraView {
    companion object {
        fun newInstance(): CameraFragment {
            return CameraFragment()
        }
    }

    override fun initView(): CameraView {
        return this
    }

    override fun initPresenter(): CameraPresenter {
        return CameraPresenter(ctx!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initWidgets() {
    }

    override fun onSendDataSuccess() {
    }
}