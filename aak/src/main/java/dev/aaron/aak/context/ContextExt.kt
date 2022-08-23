package dev.aaron.aak.context

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.app.ShareCompat


fun Context?.toast(
    @StringRes msg: Int,
    duration: Int = Toast.LENGTH_SHORT,
) {
    toast(this?.getString(msg), duration)
}

fun Context?.toast(
    msg: String?,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.showNotificationSettings() {
    val intent = Intent("android.settings.APP_NOTIFICATION_SETTINGS")
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        .putExtra("android.provider.extra.APP_PACKAGE", packageName)
    startActivity(intent)
}

fun Context.shareUrl(urlText: String) {
    ShareCompat.IntentBuilder(this)
        .setType("text/plain")
        .setText(urlText)
        .startChooser()
}

fun Context.goPlayStore(packageName: String) {
    try {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
    } catch (t: android.content.ActivityNotFoundException) {
        goLink("https://play.google.com/store/apps/details?id=$packageName")
    }
}

fun Context.goLink(url: String) {
    val urlText = if (URLUtil.isNetworkUrl(url)) url else "https://$url"
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlText)))
}
