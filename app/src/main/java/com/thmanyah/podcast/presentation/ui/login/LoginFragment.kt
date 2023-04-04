package com.thmanyah.podcast.presentation.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.thmanyah.podcast.presentation.base.BaseFragment
import com.thmanyah.podcast.R
import com.thmanyah.podcast.databinding.FragmentLoginBinding
import com.thmanyah.podcast.presentation.base.NoInternetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val viewModel by viewModels<LoginVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.userEmailLayout.editText.setText("ajbusaleh@gmail.com")
        binding!!.userPasswordLayout.editText.setText("123123aJ*")
        clickListener()
    }

    override fun getLayoutId() = R.layout.fragment_login

    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.isLoadingLiveData.observe(this) {
            binding!!.loadingLayout.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        viewModel.emailErrorLiveData.observe(this) {
            binding!!.userEmailLayout.isError = true
        }
        viewModel.passwordErrorLiveData.observe(this) {
            binding!!.userPasswordLayout.isError = true
        }
        viewModel.dialogErrorLiveData.observe(this) {message->
                    NoInternetDialog(errorMSG = message) {
                    }.show(requireActivity().supportFragmentManager, "error_dialog")
        }
        viewModel.showInternetMessage.observe(this) {
                NoInternetDialog(errorMSG = getString(R.string.no_internet_connection)) {

                }.show(requireActivity().supportFragmentManager, "error_dialog")
        }
        viewModel.loginResponseLiveData.observe(this) {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            )
        }
    }

    private fun clickListener() {
        binding!!.loginBtn.setOnClickListener {
            viewModel.login(binding!!.userEmailLayout.editText.text.toString(),binding!!.userPasswordLayout.editText.text.toString())
        }
    }
}