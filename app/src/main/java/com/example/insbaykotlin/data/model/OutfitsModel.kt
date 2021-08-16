package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

public class OutfitsModel(
    @SerializedName("country")
    val country: String? = "", @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("image")
    var image: ImageModel? = null,
    @SerializedName("image_id")
    val imageId: String? = "",
    @SerializedName("is_publish")
    val isPublish: Boolean? = false, @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("updated_at")
    val updatedAt: String? = "", @SerializedName("user_id")
    var userId: Int? = 0
)