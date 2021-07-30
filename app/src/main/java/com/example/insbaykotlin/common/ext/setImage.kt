package com.example.insbaykotlin.common.ext

import android.net.Uri
import com.example.insbaykotlin.R
import com.facebook.drawee.view.SimpleDraweeView
import java.io.File

/**
 * @param src Accept String, Int, Uri
 * @return Unit
 */

fun SimpleDraweeView.setImage(src: Any?, errorImage: Int = R.drawable.ic_placeholder_look) {
    hierarchy?.setFailureImage(errorImage)
    when (src) {
        is String -> {
            if (src.isNotEmpty()) {
                setImageURI(src)
            } else {
                setActualImageResource(errorImage)
            }
        }
        is Int -> {
            setActualImageResource(src)
        }
        is Uri -> {
            setImageURI(src, ctx)
        }
        is File -> {
            setImageURI(Uri.fromFile(src), ctx)
        }
        else -> setActualImageResource(errorImage)
    }
}