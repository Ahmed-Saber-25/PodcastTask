package com.thmanyah.podcast.di

import android.content.Context
import com.thmanyah.podcast.data.get_ways.shared_prefs.SharedPref
import com.thmanyah.podcast.utils.Network
import com.thmanyah.podcast.utils.NetworkConnectivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideAppContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Provides
    fun provideNetworkConnectivity(@ApplicationContext appContext: Context): NetworkConnectivity {
        return Network(appContext)
    }

    @Provides
    fun provideSharedPref(@ApplicationContext appContext: Context): SharedPref {
        var sharedPreferences =
            appContext.getSharedPreferences("com_thmanyah_podcast", Context.MODE_PRIVATE)
        return SharedPref(sharedPreferences)
    }
}