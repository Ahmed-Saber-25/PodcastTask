package com.thmanyah.podcast.data.get_ways.shared_prefs

import android.content.SharedPreferences
import android.util.Log
import com.thmanyah.podcast.utils.Constants
import com.google.gson.Gson
import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveUser(value: LoginResponse) {
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(value)
        editor.putString(Constants.CURRENT_USER, json)
        editor.apply()
    }
    fun getUser(): LoginResponse? {
        return Gson().fromJson(
            sharedPreferences.getString(Constants.CURRENT_USER, ""),
            LoginResponse::class.java
        )
    }

    fun clearUserData() {
        val editor = sharedPreferences.edit()
        editor.remove(Constants.CURRENT_USER)
        editor.apply()
    }
}