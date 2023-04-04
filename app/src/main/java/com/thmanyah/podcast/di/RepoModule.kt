package com.thmanyah.podcast.di

import com.thmanyah.podcast.data.repo.AuthRepoImp
import com.thmanyah.podcast.data.repo.AswaatRepoImp
import com.thmanyah.podcast.domain.repositories.AuthRepo
import com.thmanyah.podcast.domain.repositories.AswaatRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Qualifier
annotation class AuthRepoAnnotation

@Qualifier
annotation class AswaatRepoAnnotation

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @AuthRepoAnnotation
    @Binds
    abstract fun bindAuthRepo(authRepoImp: AuthRepoImp): AuthRepo

    @AswaatRepoAnnotation
    @Binds
    abstract fun bindAswaatRepo(aswaatRepoImp: AswaatRepoImp): AswaatRepo


}

