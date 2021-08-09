package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.common.Constant
import com.example.insbaykotlin.common.Param
import com.example.insbaykotlin.common.ParamKey
import com.example.insbaykotlin.data.response.SearchOutfitsResponse
import com.example.insbaykotlin.data.response.SearchProductResponse
import com.example.insbaykotlin.data.response.SearchTvStarResponse
import io.reactivex.Single

class AnoInteractor : BaseInteractor() {
    fun searchCloth(
        userType: String,
        limit: String,
        page: String,
        token: String
    ): Single<SearchOutfitsResponse> {
        return anoService.searchLook(userType, limit, page, token)
    }

    fun searchTvStar(token: String): Single<SearchTvStarResponse> {
        return anoService.searchTvStar(token)
    }

    fun searchProduct(
        page: String,
        token: String
    ): Single<SearchProductResponse> {
        var map = HashMap<String, String>()
        map[Param.USER_TYPE] = "7"
        map[Param.LIMIT] = Constant.PAGE_SIZE.toString()
        map[Param.PAGE] = page
        map[Param.ACCESS_TOKEN] = token
        return anoService.searchProduct(map)
    }

    fun searchAll(request: String, token: String): Single<String> {
        var map = HashMap<String, String>()
        map[Param.Q] = request
        map[Param.USER_TYPE] = ParamKey.userType
        map[Param.COUNTRY] = ParamKey.country
        map[Param.ACCESS_TOKEN] = token
        return anoService.searchAll(map)
    }

}