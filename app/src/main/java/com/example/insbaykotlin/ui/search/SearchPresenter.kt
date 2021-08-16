package com.example.insbaykotlin.ui.search

import android.content.Context
import android.util.Log
import android.widget.EditText
import com.example.insbaykotlin.common.ErrorKey
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.ext.networkIsConnected
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.common.util.RxSearchObservable
import com.example.insbaykotlin.data.interactor.AnoInteractor
import com.example.insbaykotlin.data.model.OutfitsModel
import com.example.insbaykotlin.data.model.ProductModel
import com.example.insbaykotlin.data.response.HistProductResponse
import com.example.insbaykotlin.data.response.HitOutfitResponse
import com.example.pview.ui.base.BasePresenterImp
import java.util.*
import kotlin.collections.ArrayList

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
                            getNewToken { searchLook(page) }
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
                            getNewToken {
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
                            getNewToken { searchProduct(page) }
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
                    .subscribe({ it ->
                        if (it.data.productResponse?.hits != null) {
                            it.data.productResponse.hits!!.also {
                                filterSearchProduct(it) { products ->
                                    v.loadProductSuccess(products)
                                }
                            }
                        } else {
                            v.searchProductSuccessNull(request)
                        }

                        if (it.data.outfitsResponse?.hits != null) {
                            it.data.outfitsResponse.hits!!.also {
                                filterSearchOutfit(it) { outfits ->
                                    v.loadOutfitSuccess(outfits)
                                }
                            }
                        } else {
                            v.searchOutfitSuccessNull(request)
                        }

                        if (it.data.usersResponse?.hit != null) {
                            it.data.usersResponse.hit!!.also {
                                v.loadTvStarSuccess(it)
                            }
                        } else v.searchOutfitSuccessNull(request)


                    }, {
                    })
                    .addToCompositeDisposable(compositeDisposable)
            }
        }
    }

    private fun filterSearchProduct(
        hits: List<HistProductResponse>?,
        result: (ArrayList<ProductModel>) -> Unit
    ) {
        if (hits == null) return
        var list = ArrayList<ProductModel>()
        for (i in hits.indices) {
            if (hits[i].productModel != null) {
                list.add(hits[i].productModel)
            }
        }
        result(list)
    }

    private fun filterSearchOutfit(
        hits: List<HitOutfitResponse>,
        result: (ArrayList<OutfitsModel>) -> Unit
    ) {
        if (hits == null) return
        var models = ArrayList<OutfitsModel>()
        for (i in hits.indices) {
            if (hits[i].image != null && hits[i].image.isNotEmpty()) {
                models.add(OutfitsModel(image = hits[i].image[0], id = hits[i].id))
            } else {
                models.add(OutfitsModel(id = hits[0].id, userId = hits[i].userId))
            }
        }
        result(models)
    }


    fun registerSearchTypingListener(lblSearch: EditText) {
        view?.also { v ->
            RxSearchObservable.fromView(lblSearch).applyIOWithAndroidMainThread().subscribe(
                {
                    v.showLoading()
                    searchAll(it)
                }, {

                }
            )
        }
    }
}