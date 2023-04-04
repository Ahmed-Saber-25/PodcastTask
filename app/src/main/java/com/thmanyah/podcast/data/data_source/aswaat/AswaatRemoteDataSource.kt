package com.thmanyah.podcast.data.data_source.aswaat

import com.thmanyah.podcast.utils.Resource
import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse

interface AswaatRemoteDataSource {
    suspend fun getPlayList(accessToken:String): Resource<PlayListResponse?>
}