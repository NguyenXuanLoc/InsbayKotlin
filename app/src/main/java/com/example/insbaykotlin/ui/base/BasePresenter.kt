package com.example.pview.ui.base

import com.example.insbaykotlin.ui.base.BaseView

abstract class BasePresenter<T : BaseView>() {

    abstract fun attachView(view: T)

    abstract fun detachView()
}