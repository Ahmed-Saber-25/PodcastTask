package com.thmanyah.podcast.data.get_ways.api_services.model.response

import com.google.gson.annotations.SerializedName

/*
* BaseResponse class is wrapper for network response
* contains:
*  1- message server message and it maybe empty
* 2- code to check the status of response
* 3- data attribute contains  server response
* 4- success boolean to check if calling has been success of not
* */
data class BaseResponse<T> (
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("data")
    val `data`: ErrorBody? = null,
    val code: Int? = null,
    @SerializedName("status")
    val status: String? = null
)
