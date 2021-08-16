package com.example.insbaykotlin.data.response

import com.example.insbaykotlin.data.model.ImageModel
import com.example.insbaykotlin.data.model.ProductModel
import com.example.insbaykotlin.data.model.UsersModel
import com.google.gson.annotations.SerializedName

class SearchMainResponse(
    @SerializedName("data") val data: SearchDataResponse,
    @SerializedName("error_code") val error_code: Int
)

class SearchDataResponse(
    @SerializedName("clothes") val productResponse: ProductResponse,
    @SerializedName("outfits") val outfitsResponse: OutfitsResponse,
    @SerializedName("users") val usersResponse: UsersResponse
)

class UsersResponse(@SerializedName("hits") val hit: List<UsersModel>)

class OutfitsResponse(
    @SerializedName("hits")
    val hits: List<HitOutfitResponse>,
)

class HitOutfitResponse(
    @SerializedName("id") val id: String,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("images") val image: List<ImageModel>
)

class ProductResponse(
    @SerializedName("hits") val hits: List<HistProductResponse>? = null,
    @SerializedName("total") val total: Int,
    @SerializedName("total_item") val total_item: Int
)

class HistProductResponse(
    @SerializedName("cloth") val productModel: ProductModel,
//    @SerializedName("owner_info") val ownerInfoModel: OwnerInfoModel
)