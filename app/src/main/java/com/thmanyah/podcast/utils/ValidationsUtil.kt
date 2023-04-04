package com.thmanyah.podcast.utils

import android.util.Log
import java.util.regex.Pattern

object ValidationsUtil {
    fun isValidUserEmail(
        userEmail: String
    ): Boolean {
        val EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        //Patterns.EMAIL_ADDRESS
        return EMAIL_ADDRESS.matcher(userEmail).matches()
    }

    fun isValidUserPassword(
        password: String
    ): Boolean {

        var regexStringBuilder = "^[a-z0-9_.]*\$"
        Log.e("Regex", regexStringBuilder)
        var validationRegex = Regex(regexStringBuilder)
        return password.matches(validationRegex)
    }

}