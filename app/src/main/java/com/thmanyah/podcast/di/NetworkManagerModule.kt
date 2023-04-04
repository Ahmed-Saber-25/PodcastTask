package com.thmanyah.podcast.di

import android.app.Activity
import com.thmanyah.podcast.utils.connectivity_manager.ConnectivitykManager
import com.thmanyah.podcast.utils.internet_access_observer.InternetAccessObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NetworkManagerModule {

    @Provides
    fun provideNetworkManager(activity: Activity, internetAccessObserver: InternetAccessObserver) =
        ConnectivitykManager(activity, internetAccessObserver)

    @Provides
    fun provideInternetAccessObserver(activity: Activity) = InternetAccessObserver(activity)
}