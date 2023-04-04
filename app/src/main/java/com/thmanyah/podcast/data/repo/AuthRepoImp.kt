package com.thmanyah.podcast.data.repo

import com.thmanyah.podcast.data.data_source.auth.RemoteAuthDataSourceImp
import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.data.get_ways.shared_prefs.SharedPref
import com.thmanyah.podcast.domain.repositories.AuthRepo
import com.thmanyah.podcast.utils.NetworkConnectivity
import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepoImp @Inject constructor(
    private val remoteDataSource: RemoteAuthDataSourceImp,
    private val networkConnectivity: NetworkConnectivity,
    private val sharedPref: SharedPref
) : AuthRepo {
    override suspend fun login(loginRequestBody: LoginRequestBody): Flow<Resource<LoginResponse>> {
        return flow {
            if (networkConnectivity.isConnected()) {
                val response = remoteDataSource.loginUser(loginRequestBody)
                if (response is Resource.Success) {
                    sharedPref.saveUser(response.data!!)
                    emit(Resource.Success(response.data))
                } else {
                    emit(Resource.Error(response.errorCode, response.errorMessage))
                }
            } else {
                emit(
                    Resource.Error(
                        errorCode = "-1",
                        errorMessage = "No Internet Connection"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}