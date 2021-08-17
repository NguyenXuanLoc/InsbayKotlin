package com.example.insbaykotlin.ui.base

import com.example.insbaykotlin.common.ErrorCode

interface BaseView {
    fun onApiCallError(e: Throwable? = null, code: Int = ErrorCode.API_ERROR) {}

    fun onNetworkError() {}

    fun getExtrasValue() {}
}