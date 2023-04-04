package com.thmanyah.podcast.data.get_ways.api_services.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val lang: String
)
