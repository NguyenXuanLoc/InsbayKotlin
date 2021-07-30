package com.example.insbaykotlin.data.base

import com.google.gson.annotations.SerializedName

open class BaseResponse<out T> {
    @SerializedName("error_code")
    val code: String? = null

    @SerializedName("message")
    val message: String? = null

    @SerializedName("data")
    val data: T? = null
}
