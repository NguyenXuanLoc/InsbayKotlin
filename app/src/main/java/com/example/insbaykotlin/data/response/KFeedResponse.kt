package com.example.insbaykotlin.data.response

import com.example.insbaykotlin.data.model.FeedModel
import com.google.gson.annotations.SerializedName

class KFeedResponse(
    @SerializedName("error_code") val error_code: Int,
    @SerializedName("feed_data") val feed_data: List<FeedModel>,
    @SerializedName("limit") val limit: Int,
    @SerializedName("next_created_at") val next_created_at: String
)