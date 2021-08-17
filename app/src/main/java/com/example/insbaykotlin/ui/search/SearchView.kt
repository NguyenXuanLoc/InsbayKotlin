package com.example.insbaykotlin.ui.search

import com.example.insbaykotlin.data.model.OutfitsModel
import com.example.insbaykotlin.data.model.ProductModel
import com.example.insbaykotlin.data.model.UsersModel
import com.example.insbaykotlin.ui.base.BaseView

interface SearchView : BaseView {
    fun showLoading()
    fun loadOutfitSuccess(model: List<OutfitsModel>)
    fun loadTvStarSuccess(model: List<UsersModel>)
    fun loadProductSuccess(model: List<ProductModel>)
    fun searchAll(products: ProductModel)
    fun loadSearchAllNull(request: String)
    fun searchTvStarSuccessNull(request: String)
    fun searchProductSuccessNull(request: String)
    fun searchOutfitSuccessNull(request: String)

}