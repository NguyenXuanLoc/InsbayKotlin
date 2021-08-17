package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class UserInfoModel(
    @SerializedName("avatar") val avatar: AvatarModel,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)