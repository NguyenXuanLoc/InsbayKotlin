package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.data.response.AnonymousResponse
import io.reactivex.Single

class PubInteractor : BaseInteractor() {
    fun getAnonymousToken(): Single<AnonymousResponse> {
        var param = HashMap<String, String>()
        param["app_key"] = "fdsgdscvdawyknmbnmnbzcxzdzx"
        return pubService.getAnonymousToken(param)
    }
}