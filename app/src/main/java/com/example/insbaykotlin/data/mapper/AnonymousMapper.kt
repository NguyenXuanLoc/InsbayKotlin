package com.example.insbaykotlin.data.mapper

import com.example.insbaykotlin.data.model.AnonymousModel
import com.example.insbaykotlin.data.response.AnonymousResponse

/*
fun AccountResponse.convertToModel(): AccountModel {
    var res = this;
    return AccountModel().apply {
        id = res.id
        phone = res.phone
        password = res.password
        partnerCode = res.partnerCode
    }
}*/
fun AnonymousResponse.convertToModel(): AnonymousModel {
    var res = this
    return AnonymousModel().apply {
        token = res.access_token
    }
}