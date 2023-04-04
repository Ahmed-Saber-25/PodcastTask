package com.thmanyah.podcast.presentation.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.thmanyah.podcast.data.get_ways.api_services.model.request.LoginRequestBody
import com.thmanyah.podcast.data.get_ways.api_services.model.response.LoginResponse
import com.thmanyah.podcast.domain.use_case.LoginUseCase
import com.thmanyah.podcast.presentation.base.BaseViewModel
import com.thmanyah.podcast.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    val loginResponseLiveData = MutableLiveData<LoginResponse>()
    val emailErrorLiveData = MutableLiveData<Boolean>()
    val passwordErrorLiveData = MutableLiveData<Boolean>()
    val dialogErrorLiveData = MutableLiveData<String>()
    private var userEmail = ""
    private var userPassword = ""

    fun login(email: String, password: String) {
        if (isLoadingLiveData.value == true) return
        userEmail = email
        userPassword = password
        if (!isValidEmail()) {
            emailErrorLiveData.value = true
            return
        }
        if (!isVaildPassword()) {
            passwordErrorLiveData.value = true
            return
        }
        isLoadingLiveData.value = true
        viewModelScope.launch {
            loginUseCase.loginRequestBody = LoginRequestBody(userEmail, userPassword)
            loginUseCase.execute().collect { response ->
                isLoadingLiveData.value = false
                if (response.errorCode == "-1") {
                    showInternetMessage.value = true
                } else if (response is Resource.Error) {
                    dialogErrorLiveData.value = response.errorMessage ?: ""
                } else {
                    loginResponseLiveData.postValue(response.data!!)
                }
            }
        }
    }

    private fun isValidEmail() = userEmail.isNotEmpty()
    private fun isVaildPassword() = userPassword.isNotEmpty()

}