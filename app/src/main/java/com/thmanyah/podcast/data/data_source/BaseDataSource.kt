package com.thmanyah.podcast.data.data_source

import android.util.Log
import com.thmanyah.podcast.data.get_ways.api_services.model.response.ErrorBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.utils.Resource

open class BaseDataSource {
    fun <T> handleError(data: ErrorBody): Resource<T> {
        return Resource.Error(
                errorMessage = data.code,
                errorCode = data.codeNumber
            )
    }

    fun <T> handleError(exception: java.lang.Exception): Resource<T> {
        Log.e("HandlingError","Error: $exception\n stackTrace: ${exception.stackTrace}")
        return Resource.Error(errorMessage = "No Internet Connection", errorCode = "-1")

    }



}