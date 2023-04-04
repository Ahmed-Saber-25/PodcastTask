package com.thmanyah.podcast.domain.repositories

import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepo {

    suspend fun login(loginRequestBody: LoginRequestBody): Flow<Resource<LoginResponse>>
}