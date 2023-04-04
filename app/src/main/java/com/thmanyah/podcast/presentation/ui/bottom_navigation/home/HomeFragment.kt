package com.thmanyah.podcast.presentation.ui.bottom_navigation.home

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thmanyah.podcast.R
import com.thmanyah.podcast.databinding.FragmentHomeBinding
import com.thmanyah.podcast.presentation.base.BaseFragment
import com.thmanyah.podcast.presentation.base.NoInternetDialog
import com.thmanyah.podcast.presentation.ui.bottom_navigation.home.adapter.EpisodeAdapter
import com.thmanyah.podcast.presentation.ui.login.LoginFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel by viewModels<HomeVM>()
    private var episodeAdapter: EpisodeAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.getPlayList()
    }

    private fun initAdapter() {
        episodeAdapter = EpisodeAdapter(rowClick = {

        }, playClick = {

        }, menuClick = {

        })
        binding!!.episodeRecycler.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding!!.episodeRecycler.adapter = episodeAdapter!!
    }

    override fun getLayoutId() = R.layout.fragment_home
    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.isLoadingLiveData.observe(this) {
            binding!!.loadingLayout.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        viewModel.dialogErrorLiveData.observe(this) {message->
            NoInternetDialog(errorMSG = message) {
            }.show(requireActivity().supportFragmentManager, "error_dialog")
        }
        viewModel.showInternetMessage.observe(this) {
            NoInternetDialog(errorMSG = getString(R.string.no_internet_connection)) {

            }.show(requireActivity().supportFragmentManager, "error_dialog")
        }
        viewModel.responseLiveData.observe(this) {
            binding!!.titleTV.text = it?.playlist?.name?:""
            binding!!.descTV.text = it?.playlist?.description?:""
            binding!!.episodesCount.text = "${it?.playlist?.episodeCount.toString()}حلقة. ${it?.playlist?.episodeTotalDuration?.div(60*60).toString()} ساعات"
            episodeAdapter!!.submitList(it?.episodes)
        }
    }
}