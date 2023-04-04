package com.thmanyah.podcast.presentation.ui.bottom_navigation.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.thmanyah.podcast.presentation.base.BaseFragment
import com.thmanyah.podcast.R
import com.thmanyah.podcast.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val viewModel by viewModels<SearchVM>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutId() = R.layout.fragment_search

}