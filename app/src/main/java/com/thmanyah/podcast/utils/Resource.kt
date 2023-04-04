package com.thmanyah.podcast.utils


sealed class Resource<T>(
    var data: T? = null,
    val errorCode: String? = null,
    var errorMessage:String?=null,
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Loading<T> : Resource<T>(null)
    class Error<T>(errorCode: String?,errorMessage: String?) : Resource<T>(null, errorCode,errorMessage)

    override fun toString(): String {
        return "Resource(data=$data, errorCode=$errorCode, errorMessage=$errorMessage)"
    }

}
