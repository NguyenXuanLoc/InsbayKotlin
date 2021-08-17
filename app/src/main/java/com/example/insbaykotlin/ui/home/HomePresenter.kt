package com.example.insbaykotlin.ui.home

import android.content.Context
import android.util.Log
import com.example.insbaykotlin.common.ErrorKey
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.ext.networkIsConnected
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.interactor.AnoInteractor
import com.example.pview.ui.base.BasePresenterImp

class HomePresenter(var ctx: Context) : BasePresenterImp<HomeView>(ctx) {
    private val interactor by lazy { AnoInteractor() }
    fun getKFeed(createAt: String = "") {
        view?.also { v ->
            if (ctx.networkIsConnected()) {
                interactor.getKFeed(CommonUtil.getDeviceToken()!!, createAt)
                    .applyIOWithAndroidMainThread()
                    .subscribe({
                        v.loadKFeedSuccess(it.feed_data, it.next_created_at)
                    }, {
                        Log.e("TAG", "Error: " + it.localizedMessage)
                    })
                    .addToCompositeDisposable(compositeDisposable)
            }
        }
    }
}