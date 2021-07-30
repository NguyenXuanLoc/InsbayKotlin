package com.example.insbaykotlin.data.base

import com.example.insbaykotlin.common.ResponseCode
import java.io.Serializable

open class BaseModel : Serializable {
    var code: String? = null
//    var message: String = ""

    fun responseIsSuccess(): Boolean {
        return code == ResponseCode.SUCCESS
    }

    fun notFound(): Boolean {
        return code == ResponseCode.NOT_FOUND
    }
}