package com.thmanyah.podcast.data.data_source.aswaat

import com.thmanyah.podcast.data.data_source.BaseDataSource
import com.thmanyah.podcast.utils.Resource
import com.thmanyah.podcast.data.get_ways.api_services.ApiService
import com.thmanyah.podcast.data.get_ways.api_services.model.response.ErrorBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import javax.inject.Inject

class AswaatRemoteDataSourceImp @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource(), AswaatRemoteDataSource {


    override suspend fun getPlayList(accessToken: String): Resource<PlayListResponse?> {
        return try {
            val response = apiService.getPlayList(accessToken)
            if (response.isSuccessful) {
                Resource.Success(data = response.body())
            } else {
                handleError(ErrorBody("","",""))
            }
        } catch (e: Exception) {
            handleError(e)
        }
    }

}