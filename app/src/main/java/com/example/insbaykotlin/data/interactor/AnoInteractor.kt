package com.example.insbaykotlin.data.interactor

import com.example.insbaykotlin.data.response.SearchOutfitsResponse
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

}