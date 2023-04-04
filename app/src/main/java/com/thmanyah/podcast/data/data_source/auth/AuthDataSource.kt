package com.thmanyah.podcast.data.data_source.auth

import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.utils.Resource
import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody

interface AuthDataSource {
    suspend fun loginUser(loginRequestBody: LoginRequestBody):Resource<LoginResponse?>
}