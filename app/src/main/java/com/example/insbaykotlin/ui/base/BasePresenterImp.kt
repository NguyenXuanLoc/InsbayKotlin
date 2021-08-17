package com.example.pview.ui.base

import android.content.Context
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.interactor.PubInteractor
import com.example.insbaykotlin.progressbar.MyProgressDialog
import com.example.insbaykotlin.ui.base.BaseView
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

open class BasePresenterImp<T : BaseView>(private val context: Context) : BasePresenter<T>() {
    private val interactor by lazy { PubInteractor() }
    private val progressDialog: MyProgressDialog by lazy { MyProgressDialog(context) }

    protected var view: T? = null
    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun showProgressDialog(cancelable: Boolean = false) {
        if (!progressDialog.isShowing) {
            progressDialog.setCancelable(cancelable)
            progressDialog.show()
        }
    }

    protected fun dismissProgressDialog() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    override fun attachView(view: T) {
        view.getExtrasValue()
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.clear()
        view = null
    }

    protected fun getNewToken(request: () -> Unit) {
        val compositeDisposable = CompositeDisposable()
        interactor.getAnonymousToken()
            .applyIOWithAndroidMainThread()
            .subscribe(
                { it ->
                    CommonUtil.saveDeviceToken(token = it.access_token)
                    request()
                }, { it ->
                    Timber.e("default Token: " + it.message)
                }
            )
            .addToCompositeDisposable(compositeDisposable)
    }
}