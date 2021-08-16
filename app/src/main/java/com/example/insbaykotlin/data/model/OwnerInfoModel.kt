package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class OwnerInfoModel(
    @SerializedName("avatar") val avatar: AvatarModel,
    @SerializedName("bank_acc_name") val bank_acc_name: String,
    @SerializedName("bank_acc_number") val bank_acc_number: String,
    @SerializedName("bank_name") val bank_name: String,
    @SerializedName("country") val country: String,
    @SerializedName("cover") val cover: String,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("email") val email: String,
    @SerializedName("facebook_avatar") val facebook_avatar: String,
    @SerializedName("facebook_connected_at") val facebook_connected_at: String,
    @SerializedName("facebook_id") val facebook_id: String,
    @SerializedName("facebook_name") val facebook_name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("is_blocked") val is_blocked: Boolean,
    @SerializedName("is_followed") val is_followed: Boolean,
    @SerializedName("last_sign_in") val last_sign_in: String,
    @SerializedName("name") val name: String,
    @SerializedName("sign_in_count") val sign_in_count: Int,
    @SerializedName("size") val size: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("user_promoted") val user_promoted: Int,
    @SerializedName("user_type") val user_type: Int,
    @SerializedName("username") val username: String,
    @SerializedName("using_facebook_avatar") val using_facebook_avatar: Boolean
)