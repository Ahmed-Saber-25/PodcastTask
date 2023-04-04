package com.thmanyah.podcast.data.get_ways.api_services

import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("auth/login")
    suspend fun login(
        @Body body: LoginRequestBody,
    ): Response<LoginResponse?>

    @GET("playlist/01GVD0TTY5RRMHH6YMCW7N1H70")
    suspend fun getPlayList(
        @Header("Authorization") token: String,
        ): Response<PlayListResponse?>
}