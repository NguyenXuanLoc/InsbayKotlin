package com.example.insbaykotlin.common.ext

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.example.insbaykotlin.MyApplication
import timber.log.Timber


fun Context.networkIsConnected(): Boolean {
    try {
        val conMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return conMgr?.activeNetworkInfo?.isConnected ?: false
    } catch (e: Exception) {
    }
    return false
}

val Context.sharedPref: SharedPreferences
    get() = MyApplication.instance.sharedPref


fun Context.showNetworkError() {
//    toast(R.string.err_network_not_available)
}

fun Context.showApiCallError(code: Int) {
//    toast(String.format(getString(R.string.err_common), code))
}

