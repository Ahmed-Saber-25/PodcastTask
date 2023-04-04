package com.thmanyah.podcast.domain.repositories

import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AswaatRepo {
    suspend fun getPlayList(): Flow<Resource<PlayListResponse>>
}