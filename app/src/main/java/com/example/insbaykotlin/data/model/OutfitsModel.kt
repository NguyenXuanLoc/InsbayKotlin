package com.example.insbaykotlin.data.model
import com.google.gson.annotations.SerializedName

public class OutfitsModel(
	@SerializedName("country") val country: String,
	@SerializedName("created_at") val created_at: String,
	@SerializedName("description") val description: String,
	@SerializedName("id") val id: String,
	@SerializedName("image") val image: ImageModel,
	@SerializedName("image_id") val image_id: String,
	@SerializedName("is_publish") val is_publish: Boolean,
	@SerializedName("name") val name: String,
	@SerializedName("type") val type: String,
	@SerializedName("updated_at") val updated_at: String,
	@SerializedName("user_id") val user_id: Int
) {

}