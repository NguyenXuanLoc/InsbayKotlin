package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class FeedModel(
    @SerializedName("comment") val comment: Int? = 0,
    @SerializedName("content") val content: String? = "",
    @SerializedName("created_at") val createdAt: String? = "",
    @SerializedName("id") val id: String? = "",
    @SerializedName("images") val images: List<ImageModel>? = null,
    @SerializedName("is_liked") val isLiked: Boolean? = false,
    @SerializedName("like") val like: Int? = 0,
    @SerializedName("object_id") val objectId: String? = "",
    @SerializedName("object_type") val objectType: String? = "",
    @SerializedName("user_info") val userInfo: UserInfoModel? = null
)