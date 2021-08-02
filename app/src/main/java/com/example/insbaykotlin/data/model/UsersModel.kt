package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class UsersModel(

) {
    @SerializedName("avatar")
    val avatar: AvatarModel? = null

    @SerializedName("bank_acc_name")
    val bankAccName: String? = ""

    @SerializedName("bank_acc_number")
    val bankAccNumber: String? = ""

    @SerializedName("bank_name")
    val bankName: String? = ""

    @SerializedName("country")
    val country: String? = ""

    @SerializedName("cover")
    val cover: String? = ""

    @SerializedName("created_at")
    val createdAt: String? = ""

    @SerializedName("email")
    val email: String? = ""

    @SerializedName("facebook_avatar")
    val facebookAvatar: String? = ""

    @SerializedName("facebook_connected_at")
    val facebookConnectedAt: String? = ""

    @SerializedName("facebook_id")
    val facebookId: String? = ""

    @SerializedName("facebook_name")
    val facebookName: String? = ""

    @SerializedName("gender")
    val gender: String? = ""

    @SerializedName("id")
    val id: Int? = 0

    @SerializedName("last_sign_in")
    val lastSignIn: String? = ""

    @SerializedName("name")
    val name: String? = ""

    @SerializedName("sign_in_count")
    val signInCount: Int? = 0

    @SerializedName("size")
    val size: String? = ""

    @SerializedName("surname")
    val surname: String? = ""

    @SerializedName("user_promoted")
    val userPromoted: Int? = 0

    @SerializedName("user_type")
    val userType: Int? = 0

    @SerializedName("username")
    val username: String? = ""

    @SerializedName("using_facebook_avatar")
    val usingFacebookAvatar: Boolean? = true
}