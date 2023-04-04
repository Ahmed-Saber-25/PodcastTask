package com.thmanyah.podcast.presentation.ui.bottom_navigation.library

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.thmanyah.podcast.presentation.base.BaseFragment
import com.thmanyah.podcast.R
import com.thmanyah.podcast.databinding.FragmentLibraryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : BaseFragment<FragmentLibraryBinding>() {
    private val viewModel by viewModels<LibraryVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutId() = R.layout.fragment_library

}