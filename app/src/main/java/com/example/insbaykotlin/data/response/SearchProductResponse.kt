package com.example.insbaykotlin.data.response

import com.example.insbaykotlin.data.model.ProductModel
import com.google.gson.annotations.SerializedName

class SearchProductResponse {
    @SerializedName("error_code")
    val errorCode: Int? = 0

    @SerializedName("next_page")
    val nextPage: Int? = 0

    @SerializedName("result")
    val result: List<ProductModel>? = ArrayList<ProductModel>()

    @SerializedName("total_record")
    val totalRecord: Int? = 0
}