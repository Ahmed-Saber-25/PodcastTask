package com.thmanyah.podcast.presentation.base

import android.R
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import jp.wasabeef.blurry.Blurry


abstract class BaseDialogFragment<Binding : ViewDataBinding?> : DialogFragment() {
    var binding: Binding? = null
    private var backgroundDrawable: BitmapDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bitmap = Blurry.with(this.activity)
            .radius(10)
            .sampling(8)
            .color(Color.argb(150, 0, 0, 0))
            .capture(this.activity!!.window.decorView).get()
        backgroundDrawable =  BitmapDrawable(resources, bitmap)
        observeViewModel()
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            dialog.window!!
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.window!!.setGravity(Gravity.BOTTOM )
            setBackground(dialog)
            dialog.setCancelable(true)
        }
    }

    fun setBackground(dialog: Dialog) {
        if (backgroundDrawable != null) dialog.window!!
            .setBackgroundDrawable(backgroundDrawable) else dialog.window!!
            .setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this.requireContext(), R.color.transparent
                    )
                )
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
    }

    private fun bindView() {
        binding!!.lifecycleOwner = this
        binding!!.executePendingBindings()
    }

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    open fun observeViewModel(){

    }
}