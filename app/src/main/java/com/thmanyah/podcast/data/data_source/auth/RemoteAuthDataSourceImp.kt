package com.thmanyah.podcast.data.data_source.auth

import com.thmanyah.podcast.data.data_source.BaseDataSource
import com.thmanyah.podcast.utils.Resource
import com.thmanyah.podcast.data.get_ways.api_services.ApiService
import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.ErrorBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import javax.inject.Inject

class RemoteAuthDataSourceImp @Inject constructor(
    private val apiService: ApiService) : BaseDataSource(), AuthDataSource {
    override suspend fun loginUser(loginRequestBody: LoginRequestBody): Resource<LoginResponse?> {

        return try {
            val response = apiService.login(loginRequestBody)
            if (response.isSuccessful&&response.code()==200) {
                Resource.Success(data = response.body())
            } else {
                handleError(response.body()?.data?: ErrorBody("","",""))
            }
        } catch (e: Exception) {
            handleError(e)
        }
    }
}