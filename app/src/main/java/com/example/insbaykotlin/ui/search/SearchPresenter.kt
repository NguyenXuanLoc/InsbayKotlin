package com.example.insbaykotlin.ui.search

import android.content.Context
import android.util.Log
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.ext.networkIsConnected
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.interactor.AnoInteractor
import com.example.pview.ui.base.BasePresenterImp
import java.util.*

class SearchPresenter(var ctx: Context) : BasePresenterImp<SearchView>(ctx) {
    private val interactor by lazy { AnoInteractor() }

    fun searchLook(page: String) {
        view?.also { v ->
            if (ctx.networkIsConnected()) {
                interactor.searchCloth("7", "10", page, CommonUtil.getDeviceToken()!!)
                    .applyIOWithAndroidMainThread()
                    .subscribe({ it ->
                        v.loadOutfitSuccess(it.outfits)
                    }, { it ->
                        Log.e("TAG", "e: " + it.message)
                    }).addToCompositeDisposable(compositeDisposable)
            } else {
                v.onNetworkError()
            }
        }
    }

    fun searchTvStar() {
        view?.also { v ->
            if (ctx.networkIsConnected()) {
                interactor.searchTvStar(CommonUtil.getDeviceToken()!!)
                    .applyIOWithAndroidMainThread()
                    .subscribe({ it ->
                        v.loadTvStarSuccess(it.users)
                    }, { it ->
                    }).addToCompositeDisposable(compositeDisposable)
            } else {
                v.onNetworkError()
            }
        }
    }

    fun searchProduct(
        page: String
    ) {
        view?.also { v ->
            if (ctx.networkIsConnected()) {
                interactor.searchProduct(page, CommonUtil.getDeviceToken()!!)
                    .applyIOWithAndroidMainThread()
                    .subscribe({ it ->
                        v.loadProductSuccess(it.result!!)
                    }, {})
                    .addToCompositeDisposable(compositeDisposable)
            }
        }
    }
}