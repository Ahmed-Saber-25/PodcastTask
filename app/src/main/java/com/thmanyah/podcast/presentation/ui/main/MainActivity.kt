package com.thmanyah.podcast.presentation.ui.main

import android.os.Bundle
import androidx.navigation.ui.navigateUp
import com.thmanyah.podcast.R
import com.thmanyah.podcast.databinding.ActivityMainBinding
import com.thmanyah.podcast.presentation.base.BaseActivity
import com.thmanyah.podcast.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainNavController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.HomeFragment -> {
                    binding!!.isAppBarVisible = true
                }
                R.id.SearchFragment -> {
                    binding!!.isAppBarVisible = true
                }
                R.id.LibraryFragment  -> {
                    binding!!.isAppBarVisible = true
                }
                else -> {
                    binding!!.isAppBarVisible = false
                }
            }
        }
        initListeners()
    }

    override fun onSupportNavigateUp(): Boolean {
        return mainNavController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun initListeners() {
        binding!!.homeTabLayout.rootLayout.setOnClickListener {
            handleNavigation(Constants.NavigationTabs.HOME)
            mainNavController.navigate(R.id.HomeFragmentNavigation)
        }
        binding!!.searchTabLayout.rootLayout.setOnClickListener {
            handleNavigation(Constants.NavigationTabs.SEARCH)
            mainNavController.navigate(R.id.SearchFragmentNavigation)

        }
        binding!!.libraryTabLayout.rootLayout.setOnClickListener {
            handleNavigation(Constants.NavigationTabs.LIBRARY)
            mainNavController.navigate(R.id.LibraryFragmentNavigation)

        }
    }

    fun handleNavigation(navigationTabs: Constants.NavigationTabs) {
        when (navigationTabs) {
            Constants.NavigationTabs.HOME -> {
                binding!!.homeTabLayout.isSelected = true
                binding!!.searchTabLayout.isSelected = false
                binding!!.libraryTabLayout.isSelected = false
            }
            Constants.NavigationTabs.SEARCH -> {
                binding!!.homeTabLayout.isSelected = false
                binding!!.searchTabLayout.isSelected = true
                binding!!.libraryTabLayout.isSelected = false
            }
            Constants.NavigationTabs.LIBRARY -> {
                binding!!.homeTabLayout.isSelected = false
                binding!!.searchTabLayout.isSelected = false
                binding!!.libraryTabLayout.isSelected = true
            }
        }

    }

    override fun getLayoutId() = R.layout.activity_main

}