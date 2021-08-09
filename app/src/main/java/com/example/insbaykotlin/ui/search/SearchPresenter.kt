package com.example.insbaykotlin.ui.search

import android.content.Context
import android.widget.EditText
import com.example.insbaykotlin.common.ErrorKey
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.ext.networkIsConnected
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.common.util.RxSearchObservable
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
                    }, { it ->
                        if (it.localizedMessage == ErrorKey.tokenExpired) {
                        getTokenAnonymous { searchLook(page) }
                    }
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
                        if (it.localizedMessage == ErrorKey.tokenExpired) {
                            getTokenAnonymous {
                                searchTvStar()
                            }
                        }
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
                    }, {
                        if (it.localizedMessage == ErrorKey.tokenExpired) {
                            getTokenAnonymous { searchProduct(page) }
                        }
                    })
                    .addToCompositeDisposable(compositeDisposable)
            }
        }
    }

    fun searchAll(request: String) {
        view?.also { v ->
            if (ctx.networkIsConnected()) {
                interactor.searchAll(request, CommonUtil.getDeviceToken()!!)
                    .applyIOWithAndroidMainThread()
                    .subscribe({
                        v.searchAll(request)
                    }, {})
                    .addToCompositeDisposable(compositeDisposable)
            }
        }
    }

    fun registerSearchTypingListener(lblSearch: EditText) {
        view?.also { v ->
            RxSearchObservable.fromView(lblSearch).applyIOWithAndroidMainThread().subscribe(
                {
                    searchAll(it)
                }, {

                }
            )
        }
    }
}