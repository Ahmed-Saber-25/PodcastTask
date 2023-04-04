package com.thmanyah.podcast.domain.use_case

import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import com.thmanyah.podcast.di.AswaatRepoAnnotation
import com.thmanyah.podcast.domain.repositories.AswaatRepo
import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayListUseCase
@Inject constructor(@AswaatRepoAnnotation private val repo: AswaatRepo) :
    SingleUseCase<PlayListResponse> {

    override suspend fun execute(): Flow<Resource<PlayListResponse>> {
        return repo.getPlayList()
    }

}