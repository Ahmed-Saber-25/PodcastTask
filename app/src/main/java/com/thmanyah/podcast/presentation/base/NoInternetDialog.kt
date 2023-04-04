package com.thmanyah.podcast.presentation.base

import android.os.Bundle
import android.view.View
import com.thmanyah.podcast.R
import com.thmanyah.podcast.databinding.BottomsheetErrorDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoInternetDialog constructor(
    var errorMSG: String,
    var dismissAction: () -> Unit
) :
    BaseDialogFragment<BottomsheetErrorDialogBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NO_FRAME, R.style.BottomSheetDialogTheme
        )
    }

    override fun getLayoutId(): Int {
        return R.layout.bottomsheet_error_dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.errorMSG = errorMSG
        binding!!.backBtn.setOnClickListener {
            dismiss()
            dismissAction.invoke()
        }
    }

}