package com.thmanyah.podcast.domain.use_case

import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.di.AuthRepoAnnotation
import com.thmanyah.podcast.domain.repositories.AuthRepo
import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase
@Inject constructor(@AuthRepoAnnotation private val repo: AuthRepo) :
    SingleUseCase<LoginResponse> {

    override suspend fun execute(): Flow<Resource<LoginResponse>> {
        return repo.login(loginRequestBody)
    }

    var loginRequestBody = LoginRequestBody("","")
}