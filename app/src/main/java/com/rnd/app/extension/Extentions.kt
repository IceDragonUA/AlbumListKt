package com.rnd.app.extension

import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.evaluation.glide.GlideApp
import com.rnd.app.ui.main.MainActivity

/**
 * @author Vladyslav Havrylenko
 * @since 24.12.2020
 */
fun FragmentActivity.root() = this as? MainActivity

fun String?.defIfNull() = this ?: ""

fun ImageView.loadFromUrl(url: String) {
    GlideApp.with(this.context.applicationContext)
        .load(url)
        .into(this)
}