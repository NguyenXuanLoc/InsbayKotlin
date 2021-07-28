package com.example.insbaykotlin.data.response

import com.google.gson.annotations.SerializedName

class AnonymousResponse(
	@SerializedName("access_token") val access_token: String,
)