package com.thmanyah.podcast.presentation.ui.bottom_navigation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.thmanyah.podcast.data.get_ways.api_services.model.response.PlayListResponse
import com.thmanyah.podcast.domain.use_case.GetPlayListUseCase
import com.thmanyah.podcast.presentation.base.BaseViewModel
import com.thmanyah.podcast.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    var getPlayListUseCase: GetPlayListUseCase
) : BaseViewModel() {
    var responseLiveData = MutableLiveData<PlayListResponse.Data?>()
    val dialogErrorLiveData = MutableLiveData<String>()
    fun getPlayList(){
        isLoadingLiveData.value = true
        viewModelScope.launch {
            getPlayListUseCase.execute().collect { response ->
                if (response.errorCode == "-1") {
                    isLoadingLiveData.value = false
                    showInternetMessage.value = true
                } else if (response is Resource.Error) {
                    isLoadingLiveData.value = false
                    dialogErrorLiveData.value = response.errorMessage ?: ""
                } else {
                    //Success api call
                    isLoadingLiveData.value = false
                    responseLiveData.value = response.data!!.data!!
                }
            }
        }
    }
}