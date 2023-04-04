package com.thmanyah.podcast.data.get_ways.api_services.model.response

import com.google.gson.annotations.SerializedName

data class ErrorBody(
    @SerializedName("code")
    var code: String?,
    @SerializedName("codeNumber")
    var codeNumber: String?,
    @SerializedName("time")
    var time: String?
)

