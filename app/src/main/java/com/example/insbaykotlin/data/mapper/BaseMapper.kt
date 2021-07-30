package com.example.task.data.mapper

import com.example.insbaykotlin.data.base.BaseModel
import com.example.insbaykotlin.data.base.BaseResponse

fun <T> BaseResponse<T>.convertToModel(): BaseModel {
    val response = this
    return BaseModel().apply {
        code = response.code
//        message = response.message ?: ""
    }
}
/*
fun <T> BaseResponseLogin<T>.convertToModel(): BaseModel {
    val response = this
    return BaseModel().apply {
        code = response.code
//        message = response.message ?: ""
    }
}*/