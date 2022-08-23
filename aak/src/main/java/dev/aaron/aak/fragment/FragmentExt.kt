package dev.aaron.aak.fragment

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import dev.aaron.aak.context.goLink
import dev.aaron.aak.context.shareUrl
import dev.aaron.aak.context.toast

fun Fragment?.goLink(url: String) {
    this?.context?.goLink(url)
}

fun Fragment?.toast(
    @StringRes msg: Int,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.context?.toast(msg, duration)
}

fun Fragment?.toast(
    msg: String?,
    duration: Int = Toast.LENGTH_SHORT
) {
    this?.context?.toast(msg, duration)
}

fun Fragment.shareUrl(textWithUrl: String) {
    requireContext().shareUrl(textWithUrl)
}
