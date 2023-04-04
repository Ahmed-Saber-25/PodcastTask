package com.thmanyah.podcast.utils

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter

@BindingAdapter("inputType")
fun setInputTypeWithString(editText: AppCompatEditText, inputTypeAsString: String?) {
    when (inputTypeAsString) {
        "email" -> {
            editText.inputType = 0x00000021
        }
        "password" -> {
            editText.inputType = 0x00000081
        }
        "phone" -> {
            editText.inputType = 0x00000003
        }
        "text" -> {
            editText.inputType = 0x00000001
        }
    }
}

@BindingAdapter("visibility")
fun visibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: Any?) {
    // load place holder
    if (imageUrl == null || (imageUrl as String).isEmpty()) return

    ImageLoader.loadImage(
        view.context,
        view,
        imageUrl as String?
    )
}