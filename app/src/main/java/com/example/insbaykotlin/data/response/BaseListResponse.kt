package com.example.insbaykotlin.data.response

import vn.vano.vicall.data.response.BaseResponse

class BaseListResponse<out T>() : BaseResponse<List<T>>()