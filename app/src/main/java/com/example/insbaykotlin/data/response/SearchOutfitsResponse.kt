package com.example.insbaykotlin.data.response

import com.example.insbaykotlin.data.model.OutfitsModel
import com.google.gson.annotations.SerializedName

class SearchOutfitsResponse(
    @SerializedName("error_code") val error_code: Int,
    @SerializedName("next_page") val next_page: Int,
    @SerializedName("outfits") val outfits: List<OutfitsModel>,
    @SerializedName("total_records") val total_records: Int
)