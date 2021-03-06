package com.example.insbaykotlin.common.ext

import android.content.Context
import android.net.ConnectivityManager


fun Context.networkIsConnected(): Boolean {
    try {
        val conMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return conMgr?.activeNetworkInfo?.isConnected ?: false
    } catch (e: Exception) {
    }
    return false
}

fun Context.showNetworkError() {
//    toast(R.string.err_network_not_available)
}

fun Context.showApiCallError(code: Int) {
//    toast(String.format(getString(R.string.err_common), code))
}

