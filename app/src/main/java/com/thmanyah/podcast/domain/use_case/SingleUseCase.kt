package com.thmanyah.podcast.domain.use_case

import com.thmanyah.podcast.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SingleUseCase<R> {
    suspend fun execute(): Flow<Resource<R>>
}