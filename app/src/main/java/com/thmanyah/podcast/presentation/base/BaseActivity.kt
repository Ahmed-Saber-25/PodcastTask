package com.thmanyah.podcast.presentation.base

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.thmanyah.podcast.R
import com.thmanyah.podcast.data.get_ways.shared_prefs.SharedPref
import com.thmanyah.podcast.utils.Constants
import java.util.*


abstract class BaseActivity<Binding : ViewDataBinding?> : AppCompatActivity() {
    var binding: Binding? = null
    lateinit var mainNavController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        mainNavController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(mainNavController.graph)
        observeViewModel()
    }
    override fun onSupportNavigateUp(): Boolean {
        return mainNavController.navigateUp()
    }
    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }
    open fun observeViewModel(){

    }


}