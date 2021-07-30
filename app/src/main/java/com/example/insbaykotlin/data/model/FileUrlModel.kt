package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class FileUrlModel(
	@SerializedName("100") val i100: String,
	@SerializedName("125") val i125: String,
	@SerializedName("150") val i150: String,
	@SerializedName("200") val i200: String,
	@SerializedName("400") val i400: String,
	@SerializedName("600") val i600: String,
	@SerializedName("75") val i75: String,
	@SerializedName("default") val default: String
)