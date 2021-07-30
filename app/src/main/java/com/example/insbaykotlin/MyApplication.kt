package com.example.insbaykotlin

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.common.util.SharedPreferencesUtil
import com.example.insbaykotlin.data.interactor.PubInteractor
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.ctx
import timber.log.Timber

class MyApplication : MultiDexApplication() {
    val sharedPref by lazy { SharedPreferencesUtil.customPrefs(ctx) }

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.e("TAG", "MY APPLICATIOn")
        getTokenAnonymous()
        initTimber()
    }

    private fun getTokenAnonymous() {
        val compositeDisposable = CompositeDisposable()
        val interactor = PubInteractor()
        interactor.getAnonymousToken()
            .applyIOWithAndroidMainThread()
            .subscribe(
                { it ->
                    Log.e("TAG", "saveTOken: " + it.access_token)
                    CommonUtil.saveDeviceToken(token = it.access_token)
                }, { it ->
                    Timber.e("default Token: " + it.message)
                }
            ).addToCompositeDisposable(compositeDisposable)
        compositeDisposable.dispose()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
        }
    }
}