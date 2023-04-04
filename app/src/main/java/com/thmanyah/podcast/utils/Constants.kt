package com.thmanyah.podcast.utils

object Constants {
    const val BASE_URL = "https://staging.podcast.kaitdev.com/client/api/"
    const val BASE_IMAGE_URL = ""
    const val NETWORK_TIMEOUT = 60
    const val CURRENT_USER = "CURRENT_USER"

    enum class NavigationTabs(var value: Int) {
        HOME(1), SEARCH(2), LIBRARY(3);
    }
   var arMonths = arrayOf(
        "يناير",
        "فبراير",
        "مارس",
        "إبريل",
        "مايو",
        "يونيو",
        "يوليو",
        "أغسطس",
        "سبتمبر",
        "أكتوبر",
        "نوفمبر",
        "ديسمبر"
    )
}
