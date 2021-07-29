package com.example.insbaykotlin.data.response

import com.google.gson.annotations.SerializedName

class DataResponse(
    @SerializedName("error_code") val error_code: String,
    @SerializedName("next_page") val next_page: String,
)