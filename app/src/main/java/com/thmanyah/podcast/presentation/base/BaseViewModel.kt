package com.thmanyah.podcast.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel() {
    var isLoadingLiveData = MutableLiveData<Boolean>()
    val showInternetMessage = MutableLiveData<Boolean>()
}