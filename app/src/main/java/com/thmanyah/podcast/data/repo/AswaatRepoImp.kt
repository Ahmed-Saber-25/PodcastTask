package com.thmanyah.podcast.data.repo

import com.thmanyah.podcast.utils.NetworkConnectivity
import com.thmanyah.podcast.data.data_source.aswaat.AswaatRemoteDataSourceImp
import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import com.thmanyah.podcast.data.get_ways.shared_prefs.SharedPref
import com.thmanyah.podcast.domain.repositories.AswaatRepo
import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AswaatRepoImp @Inject constructor(
    private val remoteDataSource: AswaatRemoteDataSourceImp,
    private val networkConnectivity: NetworkConnectivity,
    private val sharedPref: SharedPref
) : AswaatRepo {

    override suspend fun getPlayList(): Flow<Resource<PlayListResponse>> {
        return flow {
            if (networkConnectivity.isConnected()) {
                val accessToken = "Bearer " + sharedPref.getUser()?.accessToken
                val response = remoteDataSource.getPlayList(accessToken)
                if (response is Resource.Success) {
                    emit(Resource.Success(response.data!!))
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