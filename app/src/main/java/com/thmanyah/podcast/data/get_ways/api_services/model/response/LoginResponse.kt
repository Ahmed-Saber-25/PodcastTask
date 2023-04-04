package com.thmanyah.podcast.data.get_ways.api_services.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("accessToken")
    var accessToken: String?= null,
    @SerializedName("expiresIn")
    var expiresIn: Int?= null,
    @SerializedName("refreshToken")
    var refreshToken: String?= null,
    @SerializedName("user")
    var user: User? = null,
    @SerializedName("data")
    var `data`: ErrorBody? = null,
    @SerializedName("message")
    var message: List<String?>?= null,
    @SerializedName("status")
    var status: String?= null
) {
    data class User(
        @SerializedName("email")
        var email: String?,
        @SerializedName("userId")
        var userId: String?,
        @SerializedName("verified")
        var verified: Boolean?
    )
}
