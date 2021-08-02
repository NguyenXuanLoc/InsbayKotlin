package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class ProductModel {
    @SerializedName("album_id") val albumId : String?=""
    @SerializedName("brand") val brand : String?=""
    @SerializedName("cloth_clone") val clothClone : String?=""
    @SerializedName("color") val color : String?=""
    @SerializedName("condition") val condition : String?=""
    @SerializedName("country") val country : String?=""
    @SerializedName("created_at") val createdAt : String?=""
    @SerializedName("currency") val currency : String?=""
    @SerializedName("description") val description : String?=""
    @SerializedName("id") val id : String?=""
    @SerializedName("images") val images : List<ImageModel>?=null
    @SerializedName("integrate_data_id") val integrateDataId : String?=""
    @SerializedName("is_publish") val isPublish : Boolean?=true
    @SerializedName("location") val location : String?=""
    @SerializedName("name") val name : String?=""
    @SerializedName("origin_owner") val originOwner : String?=""
    @SerializedName("origin_price") val originPrice : String?=""
    @SerializedName("price") val price : String?=""
    @SerializedName("size") val size : String?=""
    @SerializedName("style") val style : String?=""
    @SerializedName("type") val type : Int?=0
    @SerializedName("updated_at") val updatedAt : String?=""
    @SerializedName("user_id") val userId : Int?=0
}