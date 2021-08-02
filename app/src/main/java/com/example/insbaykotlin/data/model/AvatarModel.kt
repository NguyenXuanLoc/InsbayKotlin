package com.example.insbaykotlin.data.model

import com.google.gson.annotations.SerializedName

class AvatarModel(
	@SerializedName("album_id") val album_id: String,
	@SerializedName("created_at") val created_at: String,
	@SerializedName("file_url") val file_url: FileUrlModel,
	@SerializedName("height") val height: Int,
	@SerializedName("id") val id: String,
	@SerializedName("owner_id") val owner_id: Int,
	@SerializedName("position") val position: String,
	@SerializedName("tags") val tags: String,
	@SerializedName("width") val width: Int
)