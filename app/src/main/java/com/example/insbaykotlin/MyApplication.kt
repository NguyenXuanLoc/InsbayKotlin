package com.example.insbaykotlin

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.insbaykotlin.common.ext.addToCompositeDisposable
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.common.util.SharedPreferencesUtil
import com.example.insbaykotlin.data.interactor.PubInteractor
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
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
        initFresco()
        getTokenAnonymous()
        initTimber()
    }

    private fun initFresco() {
        ImagePipelineConfig.newBuilder(this).apply {
            isDownsampleEnabled = true
        }
            .build()
            .run {
                Fresco.initialize(this@MyApplication, this)
            }
    }

    private fun getTokenAnonymous() {
        val compositeDisposable = CompositeDisposable()
        val interactor = PubInteractor()
        interactor.getAnonymousToken()
            .applyIOWithAndroidMainThread()
            .subscribe(
                { it ->
                    CommonUtil.saveDeviceToken(token = it.access_token)
                }, { it ->
                    Timber.e("default Token: " + it.message)
                }
            ).addToCompositeDisposable(compositeDisposable)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
        }
    }
}