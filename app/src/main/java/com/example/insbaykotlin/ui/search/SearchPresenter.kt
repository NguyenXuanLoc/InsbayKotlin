package com.example.insbaykotlin.ui.search

import android.content.Context
import android.util.Log
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.ext.networkIsConnected
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.interactor.AnoInteractor
import com.example.pview.ui.base.BasePresenterImp

class SearchPresenter(var ctx: Context) : BasePresenterImp<SearchView>(ctx) {
    private val interactor by lazy { AnoInteractor() }

    fun searchLook(page: String) {
        view?.also { v ->
            if (ctx.networkIsConnected()) {
                interactor.searchCloth("7", "10", page, CommonUtil.getDeviceToken()!!)
                    .applyIOWithAndroidMainThread()
                    .subscribe({ it ->
                        v.loadOutfitSuccess(it.outfits)
                        Log.e("TAG", "ok: " + it.total_records)
                    }, { it ->
                        Log.e("TAG", "e: " + it.message)
                    })
            } else {
                v.onNetworkError()
            }
        }

    }
}