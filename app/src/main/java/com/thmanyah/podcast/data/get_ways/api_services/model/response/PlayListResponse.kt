package com.thmanyah.podcast.data.get_ways.api_services.model.response


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import com.thmanyah.podcast.utils.Constants
import java.text.SimpleDateFormat
import java.util.*

data class PlayListResponse(
    @SerializedName("data")
    var `data`: Data?
) {
    data class Data(
        @SerializedName("episodes")
        var episodes: List<Episode?>?,
        @SerializedName("playlist")
        var playlist: Playlist?
    ) {
        data class Episode(
            @SerializedName("audioLink")
            var audioLink: String?,
            @SerializedName("chapters")
            var chapters: List<Chapter?>?,
            @SerializedName("createdAt")
            var createdAt: String?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("duration")
            var duration: Int?,
            @SerializedName("durationInSeconds")
            var durationInSeconds: Int?,
            @SerializedName("id")
            var id: String?,
            @SerializedName("image")
            var image: String?,
            @SerializedName("imageBigger")
            var imageBigger: String?,
            @SerializedName("isDeleted")
            var isDeleted: Boolean?,
            @SerializedName("isEditorPick")
            var isEditorPick: Boolean?,
            @SerializedName("itunesId")
            var itunesId: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("podcastItunesId")
            var podcastItunesId: String?,
            @SerializedName("podcastName")
            var podcastName: String?,
            @SerializedName("releaseDate")
            var releaseDate: String?,
            @SerializedName("sentNotification")
            var sentNotification: Boolean?,
            @SerializedName("type")
            var type: Int?,
            @SerializedName("updatedAt")
            var updatedAt: String?,
            @SerializedName("views")
            var views: Int?
        ) : java.io.Serializable  {
                val dateWithDuration: String
                @SuppressLint("SimpleDateFormat")
                get() {
                    return try {
                        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        val date = input.parse(releaseDate!!)!!
                        val calendar = Calendar.getInstance()
                        calendar.timeInMillis = date.time
                        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
                        val monthIndex = calendar.get(Calendar.MONTH) + 1
                        val month = Constants.arMonths[monthIndex]
                        val year = calendar.get(Calendar.YEAR).toString()
                        return "$month $year . ${durationInSeconds?.div(60).toString()} ${"دقيقة"}"
                    } catch (e: Exception) {
                        return ""
                    }
                }
            data class Chapter(
                @SerializedName("start")
                var start: Int?,
                @SerializedName("title")
                var title: String?
            )
        }

        data class Playlist(
            @SerializedName("access")
            var access: String?,
            @SerializedName("createdAt")
            var createdAt: String?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("episodeCount")
            var episodeCount: Int?,
            @SerializedName("episodeTotalDuration")
            var episodeTotalDuration: Int?,
            @SerializedName("followingCount")
            var followingCount: Int?,
            @SerializedName("id")
            var id: String?,
            @SerializedName("image")
            var image: String?,
            @SerializedName("isDeleted")
            var isDeleted: Boolean?,
            @SerializedName("isSubscribed")
            var isSubscribed: Boolean?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("status")
            var status: String?,
            @SerializedName("type")
            var type: Int?,
            @SerializedName("updatedAt")
            var updatedAt: String?,
            @SerializedName("userId")
            var userId: String?
        )
    }
}