package com.thmanyah.podcast.presentation.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.fragment.findNavController
import com.thmanyah.podcast.presentation.base.BaseFragment
import com.thmanyah.podcast.R
import dagger.hilt.android.AndroidEntryPoint
import com.thmanyah.podcast.data.get_ways.shared_prefs.SharedPref
import com.thmanyah.podcast.databinding.FragmentSplashBinding
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    @Inject
    lateinit var sharedPref: SharedPref
    var isAuthorized :Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        isAuthorized = sharedPref.getUser()!=null
        Handler().postDelayed({
            if(isAuthorized){
                navigateToHome()
            }else {
                navigateToLogin()
            }
        }, 2000)
    }

    private fun navigateToLogin() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
    }
    private fun navigateToHome() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
    }

    override fun getLayoutId() = R.layout.fragment_splash

}