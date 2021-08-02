package com.example.insbaykotlin.data.response
import com.example.insbaykotlin.data.model.UsersModel
import com.google.gson.annotations.SerializedName

 class SearchTvStarResponse(
	@SerializedName("error_code") val error_code: Int,
	@SerializedName("next_page") val next_page: Int,
	@SerializedName("user_type") val user_type: Int,
	@SerializedName("users") val users: List<UsersModel>
)