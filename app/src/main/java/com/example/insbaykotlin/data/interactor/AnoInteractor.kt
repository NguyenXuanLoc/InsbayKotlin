package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.data.response.DataResponse
import io.reactivex.Single

class AnoInteractor : BaseInteractor() {
    fun searchCloth(): Single<DataResponse> {
        var token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjM5MTYzMDEsImlhdCI6MTYyMzA1MTcwMSwic3ViIjo2MiwiaXNzIjoiOWpzc1BneU1Wa0JVOUROekd4eGFWN21IZ2FQWWxVS0oiLCJtZXRhIjoie1wiaWRcIjogNjIsIFwidXNlcm5hbWVcIjogXCJyZWQgb2Nib1wiLCBcImNvdW50cnlcIjogXCJQTFwifSIsInJvbGUiOiJ1c2VyIn0.iGSaDL3YB1WuunRQs-h9Mo495AINvRtc0-1QUzxvX1c"
        var q = "f"
        var limit = "20"
        var userType = "7"
        var country = "KR"
        return anoService.searchProduct(token, q, limit, userType, country);
    }
}